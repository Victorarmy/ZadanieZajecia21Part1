package controller;

import model.EntityType;
import service.BudgetEntityService;
import dao.Dao;
import dao.OperationsDao;

import java.util.Scanner;

public class MainLoop {

    private static final int EXIT = 0;
    private static final int ADD_NEW_BUDGET_ENTITY = 1;
    private static final int PRINT_ALL_INCOMES = 2;
    private static final int PRINT_ALL_EXPENSES = 3;
    private static final int PRINT_ALL_INCOMES_FROM_DATE = 4;
    private static final int PRINT_ALL_EXPENSES_FROM_DATE = 5;
    private static final int PRINT_ALL_INCOMES_FROM_AMOUNT = 6;
    private static final int PRINT_ALL_EXPENSES_FROM_AMOUNT = 7;

    private Scanner scanner;
    private BudgetEntityService budgetEntityService;
    private Dao dao;

    public MainLoop() {
        dao = new OperationsDao();
        scanner = new Scanner(System.in);
        budgetEntityService = new BudgetEntityService(dao, scanner);
    }

    public void startLoop() {
        printOptions();
        int userOption;
        while ((userOption = scanner.nextInt()) != 0) {
            switch (userOption) {
                case 1:
                    int result = budgetEntityService.createAndSaveEntity();
                    String resultString = result > 0 ? "Pomyslnie zapisano encję" : "Nie udało się zapisać encji";
                    System.out.println(resultString);
                    break;
                case 2:
                    budgetEntityService.printAll(EntityType.INCOME);
                    break;
                case 3:
                    budgetEntityService.printAll(EntityType.EXPENSE);
                    break;
                case 4:
                    budgetEntityService.printInDate(EntityType.INCOME);
                    break;
                case 5:
                    budgetEntityService.printInDate(EntityType.EXPENSE);
                    break;
                case 6:
                    budgetEntityService.printFromAmount(EntityType.INCOME);
                    break;
                case 7:
                    budgetEntityService.printFromAmount(EntityType.EXPENSE);
                    break;
                default:
                    System.out.println("Nie ma takiej opcji");
            }
            printOptions();
        }
        System.out.println("Kończenie programu");
        dao.closeConnection();
        scanner.close();
    }

    private void printOptions() {
        System.out.println("Dostępne opcje: ");
        System.out.println(EXIT + ". Wyjscie ");
        System.out.println(ADD_NEW_BUDGET_ENTITY + ". Dodaj nowy wydatek/przychód");
        System.out.println(PRINT_ALL_INCOMES + ". Wyświetl wszystkie przychody");
        System.out.println(PRINT_ALL_EXPENSES + ". Wyświetl wszystkie wydatki");
        System.out.println(PRINT_ALL_INCOMES_FROM_DATE + ". Wyświetl wszystkie przychody w wybranym przedziale czasowym");
        System.out.println(PRINT_ALL_EXPENSES_FROM_DATE + ". Wyświetl wszystkie wydatki w wybranym przedziale czasowym");
        System.out.println(PRINT_ALL_INCOMES_FROM_AMOUNT+ ". Wyświetl wszystkie przychody od wybranej kwoty");
        System.out.println(PRINT_ALL_EXPENSES_FROM_AMOUNT + ". Wyświetl wszystkie wydatki od wybranej kwoty");
    }
}
