package org.example.backend.Service;

import org.example.backend.Model.Expense;
import org.example.backend.Repository.ExpenseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseServiceImplTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @InjectMocks
    private ExpenseServiceImpl expenseService;

    @BeforeEach
    void setUp() {
        //Initialize objects annotated with Mockito annotations for given testClass: @Mock, @Spy, @Captor, @InjectMocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveProduct() {
    }

    @Test
    void fetchAll() {
    }

    @Test
    @DisplayName("Positive find by id")
    void fetchByIdPositive() {
        Expense givenExpense = new Expense();
        givenExpense.setId(1L);
        givenExpense.setProductName("Mac");
        givenExpense.setDescription("An OS");
        givenExpense.setCost(new BigDecimal(95.99));
        Mockito.when(this.expenseRepository.findById(1L)).thenReturn(Optional.of(givenExpense));
        Expense result = expenseService.fetchById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Mac", result.getProductName());
    }

    @Test
    @DisplayName("Negative find by id")
    void fetchByIdNegative() {
//        Expense givenExpense = new Expense();
//        givenExpense.setId(1L);
//        givenExpense.setProductName("Mac");
//        givenExpense.setDescription("An OS");
//        givenExpense.setCost(new BigDecimal(95.99));
        Mockito.when(this.expenseRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
        Expense result = expenseService.fetchById(1L);
        assertNull(result);
    }
}