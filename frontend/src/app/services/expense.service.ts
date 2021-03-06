import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Expense } from '../models/expense';

@Injectable({
  providedIn: 'root'
})
export class ExpenseService {

  private baseUrl: string = 'http://localhost:8080/api/v1/expenses';
  constructor(private httpClient: HttpClient) { }

  getExpenses(): Observable<Expense[]> {
    return this.httpClient.get<Expense[]>(this.baseUrl);
  }

  saveExpenses(expense: Expense): Observable<Expense> {
    return this.httpClient.post<Expense>(this.baseUrl, expense);
  }

  getExpenseById(id: number): Observable<Expense> {
    return this.httpClient.get<Expense>(`${this.baseUrl}/${id}`);
  }

  deleteExpenseById(id: number): Observable<any> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
}
