package org.example.backend.Model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "expense_table")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String description;
    private BigDecimal cost;

    public Expense() {
    }

    public Expense(String productName, String description, BigDecimal cost) {
        this.productName = productName;
        this.description = description;
        this.cost = cost;
    }

    public Expense(Long id, String productName, String description, BigDecimal cost) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}
