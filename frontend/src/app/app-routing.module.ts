import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddExpenseComponent } from './components/add-expense/add-expense.component';
import { ExpenseListComponent } from './components/expense-list/expense-list.component';

const routes: Routes = [
  { path: 'display', component: ExpenseListComponent },
  { path: '', redirectTo: 'display', pathMatch: 'full' },
  { path: 'addExpense', component: AddExpenseComponent },
  { path: 'updateExpense/:id', component: AddExpenseComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
