package org.example.backend.Service;

import org.example.backend.Model.Expense;
import org.example.backend.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Expense saveProduct(Expense expense) {
        return expenseRepository.save(expense);
    }
}
