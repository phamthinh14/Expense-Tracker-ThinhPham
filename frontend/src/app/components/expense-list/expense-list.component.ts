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
      data => this.expenses = data
    );
  }

}
