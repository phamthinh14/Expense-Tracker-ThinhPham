import { Component, OnInit } from '@angular/core';
import { Expense } from 'src/app/models/expense';
import { ExpenseService } from 'src/app/services/expense.service';

@Component({
  selector: 'app-expense-list',
  templateUrl: './expense-list.component.html',
  styleUrls: ['./expense-list.component.css']
})
export class ExpenseListComponent implements OnInit {

  expenses: Expense[] = [];

  constructor(private expenseService: ExpenseService) { }

  ngOnInit(): void {
    this.listAllExpensesHelper();
  }

  deleteExpense(id: number) {
    this.expenseService.deleteExpenseById(id).subscribe(data => {
      console.log(data);
      this.listAllExpensesHelper();
    });
  }

  listAllExpensesHelper() {
    this.expenseService.getExpenses().subscribe(
      data => this.expenses = this.filterAndSortExpenese(data)
    );
  }

  filters = {
    keyword: '',
    sortBy: 'Name'
  }

  filterAndSortExpenese(expenses: Expense[]) {
    return expenses.filter(e => {
      return e.productName.toLowerCase().includes(this.filters.keyword.toLowerCase());
    }).sort(
      (a, b) => {
        return a.productName.toLowerCase() < b.productName.toLowerCase() ? -1 : 1;
      }
    );
  }

}
