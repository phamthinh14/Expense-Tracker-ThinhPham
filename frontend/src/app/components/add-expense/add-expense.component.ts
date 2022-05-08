import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Expense } from 'src/app/models/expense';
import { ExpenseService } from 'src/app/services/expense.service';

@Component({
  selector: 'app-add-expense',
  templateUrl: './add-expense.component.html',
  styleUrls: ['./add-expense.component.css']
})
export class AddExpenseComponent implements OnInit {

  expenseObj: Expense = new Expense();

  constructor(private expenseService: ExpenseService, private router: Router) { }

  ngOnInit(): void {
  }

  saveExpense() {
    this.expenseService.saveExpenses(this.expenseObj).subscribe(
      data => {
        console.log(data);
        this.router.navigateByUrl('/expenses');
        this.goToDisplay();
      }
    );
  }

  goToDisplay(){
    this.router.navigate(['/display'])
  }


}
