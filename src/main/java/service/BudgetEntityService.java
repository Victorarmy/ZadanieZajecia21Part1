package service;

import model.EntityType;
import ioutils.UserInput;
import dao.Dao;
import model.BudgetEntity;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BudgetEntityService {

    private Dao dao;
    private UserInput userInput;

    public BudgetEntityService(Dao dao, Scanner scanner) {
        this.dao = dao;
        this.userInput = new UserInput(scanner);
    }

    public int createAndSaveEntity() {
        BudgetEntity budgetEntity = userInput.createBudgetEntity();
        try {
            return dao.save(budgetEntity);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void printAll(EntityType type) {
        try {
            List<BudgetEntity> budgetEntities = dao.findAll(type);
            printAll(budgetEntities);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printInDate(EntityType type) {
        try {
            LocalDate dateFrom = userInput.getFromDate();
            LocalDate dateTo = userInput.getToDate();
            List<BudgetEntity> budgetEntities = dao.findAllFromToDate(dateFrom, dateTo, type);
            printAll(budgetEntities);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printFromAmount(EntityType type) {
        try {
            int amount = userInput.getAmount();
            List<BudgetEntity> budgetEntities = dao.findAllFromAmount(amount, type);
            printAll(budgetEntities);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void printAll(List<BudgetEntity> budgetEntities) {
        if (!budgetEntities.isEmpty()) {
            budgetEntities.forEach(System.out::println);
        } else {
            System.out.println("Nie odnaleziono żadnych rekordów");
        }
    }
}
