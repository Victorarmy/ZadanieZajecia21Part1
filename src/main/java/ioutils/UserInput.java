package ioutils;

import model.BudgetEntity;
import model.EntityType;

import java.time.LocalDate;
import java.util.Scanner;

public class UserInput {

    private Scanner scanner;

    public UserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public BudgetEntity createBudgetEntity() {
        System.out.println("Podaj typ: ");
        for (int i = 0; i < EntityType.values().length; i++) {
            System.out.println(i + " " + EntityType.values()[i].getName());
        }
        String type = EntityType.values()[scanner.nextInt()].getName();
        scanner.nextLine();
        System.out.println("Podaj opis: ");
        String description = scanner.nextLine();
        System.out.println("Podaj kwotę: ");
        int amount = scanner.nextInt();
        System.out.println("Podaj datę: ");
        LocalDate date = getDate();
        return new BudgetEntity(type, description, amount, date);
    }

    public LocalDate getFromDate() {
        System.out.println("Podaj datę od której wyszukać : ");
        return getDate();
    }
    public LocalDate getToDate() {
        System.out.println("Podaj datę do której wyszukiwać: ");
        return getDate();
    }

    private LocalDate getDate() {
        System.out.println("Podaj rok: ");
        int year = scanner.nextInt();
        System.out.println("Podaj miesiąc: ");
        int month = scanner.nextInt();
        System.out.println("Podaj dzień: ");
        int day= scanner.nextInt();
        scanner.nextLine();
        return LocalDate.of(year, month, day);
    }

    public int getAmount() {
        System.out.println("Od jakiej kwoty chcesz szukać? ");
        int amount = scanner.nextInt();
        scanner.nextLine();
        return amount;
    }
}
