package org.example.backend.Controller;


import org.example.backend.Model.Expense;
import org.example.backend.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/expenses")
    public ResponseEntity<Expense> saveProduct(@RequestBody Expense expense) {
        Expense expenseTmp = expenseService.saveProduct(expense);
        return new ResponseEntity<>(expenseTmp, HttpStatus.OK);
    }
}
