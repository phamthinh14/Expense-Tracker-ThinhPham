package org.example.backend.Service;

import org.example.backend.Model.Expense;

import java.util.List;

public interface ExpenseService {
    Expense saveProduct(Expense expense);

    List<Expense> fetchAll();

    Expense fetchById(Long id);
    void deleteExpenseById(Long id);
}
