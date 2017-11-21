package model;

import java.time.LocalDate;

public class BudgetEntity {

    private Long id;
    private String type;
    private String description;
    private int amount;
    private LocalDate date;

    public BudgetEntity(String type, String description, int amount, LocalDate date) {
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return  type  + " opis: " + description + ", kwota: " + amount +
                ", data: " + date;
    }
}
