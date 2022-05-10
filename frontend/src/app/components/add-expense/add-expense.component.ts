import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Expense } from 'src/app/models/expense';
import { ExpenseService } from 'src/app/services/expense.service';

@Component({
  selector: 'app-add-expense',
  templateUrl: './add-expense.component.html',
  styleUrls: ['./add-expense.component.css']
})
export class AddExpenseComponent implements OnInit {

  id!: number;
  expenseObj: Expense = new Expense();

  constructor(private expenseService: ExpenseService, private router: Router, private activatedRouter: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.activatedRouter.snapshot.params['id'];
    this.expenseService.getExpenseById(this.id).subscribe(
      data => {
        this.expenseObj = data;
      },
      error =>{
        console.log(error);
      }
    );
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

  goToDisplay() {
    this.router.navigate(['/display'])
  }


}
