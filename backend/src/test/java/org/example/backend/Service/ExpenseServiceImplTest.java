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
import java.util.ArrayList;
import java.util.List;
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
    @DisplayName("Save Product Positive")
    void saveProduct() {
        Expense givenExpense = new Expense();
        givenExpense.setId(1L);
        givenExpense.setProductName("Mac");
        givenExpense.setDescription("An OS");
        givenExpense.setCost(new BigDecimal(95.99));
        Mockito.when(this.expenseRepository.save(givenExpense)).thenReturn(givenExpense);
        Expense result = expenseService.saveProduct(givenExpense);
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    @DisplayName("Positive Fetch All Records")
    void fetchAllPositive() {
        Expense givenExpense1 = new Expense();
        givenExpense1.setId(1L);
        givenExpense1.setProductName("Mac");
        givenExpense1.setDescription("An OS based on Unix");
        givenExpense1.setCost(new BigDecimal(95.99));
        Expense givenExpense2 = new Expense();
        givenExpense2.setId(2L);
        givenExpense2.setProductName("Linux");
        givenExpense2.setDescription("An old");
        givenExpense2.setCost(new BigDecimal(5.99));
        Expense givenExpense3 = new Expense();
        givenExpense3.setId(3L);
        givenExpense3.setProductName("Windows");
        givenExpense3.setDescription("An OS with Linux");
        givenExpense3.setCost(new BigDecimal(195.59));
        List<Expense> givenExpenseList = new ArrayList<>();
        givenExpenseList.add(givenExpense1);
        givenExpenseList.add(givenExpense2);
        givenExpenseList.add(givenExpense3);
        Mockito.when(this.expenseRepository.findAll()).thenReturn(givenExpenseList);
        List<Expense> resultList = expenseService.fetchAll();
        assertNotNull(resultList);
        assertEquals("An old", resultList.get(1).getDescription());
        assertEquals(new BigDecimal(195.59), resultList.get(2).getCost());
    }

    @Test
    @DisplayName("Negative Fetch All Records")
    void fetchAllNegative() {
        List<Expense> givenExpenseList = new ArrayList<>();
        Mockito.when(this.expenseRepository.findAll()).thenReturn(givenExpenseList);
        List<Expense> resultList = expenseService.fetchAll();
        assertTrue(true, String.valueOf(resultList.isEmpty()));
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
        Mockito.when(this.expenseRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
        Expense result = expenseService.fetchById(1L);
        assertNull(result);
    }
}