package org.example.backend.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.backend.Model.Expense;
import org.example.backend.Service.ExpenseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ExpenseControllerTest {
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    @Mock
    private ExpenseService expenseService;
    @InjectMocks
    private ExpenseController expenseController;

    Expense givenExpense1;
    Expense givenExpense2;
    Expense givenExpense3;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(expenseController).build();
        givenExpense1 = new Expense();
        givenExpense1.setId(1L);
        givenExpense1.setProductName("Mac");
        givenExpense1.setDescription("An OS based on Unix");
        givenExpense1.setCost(new BigDecimal(95.99));
        givenExpense2 = new Expense();
        givenExpense2.setId(2L);
        givenExpense2.setProductName("Linux");
        givenExpense2.setDescription("An old OS");
        givenExpense2.setCost(new BigDecimal(5.99));
        givenExpense3 = new Expense();
        givenExpense3.setId(3L);
        givenExpense3.setProductName("Windows");
        givenExpense3.setDescription("An OS with Linux");
        givenExpense3.setCost(new BigDecimal(195.59));
    }

    @Test
    void saveProduct() {
    }

    @Test
    @DisplayName("Size of fetch all")
    void fetchExpenses() {
        List<Expense> expenseList = new ArrayList<>(Arrays.asList(givenExpense1, givenExpense2, givenExpense3));
        Mockito.when(this.expenseService.fetchAll()).thenReturn(expenseList);
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .get("/api/v1/expenses")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Detail of fetch all")
    void fetchDetailExpensesTests(){
        List<Expense> expenseList = new ArrayList<>(Arrays.asList(givenExpense1, givenExpense2, givenExpense3));
        Mockito.when(this.expenseService.fetchAll()).thenReturn(expenseList);
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .get("/api/v1/expenses")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[1].description", is("An old OS")))
                    .andExpect( MockMvcResultMatchers.jsonPath("$[0].cost", is(new BigDecimal(95.99))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[2].productName", is("Windows")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void fetchExpenseById() {
    }

    @Test
    void deleteExpense() {
    }
}