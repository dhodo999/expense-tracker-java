import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Expense> expenses = StoreExpense.LoadExpenses();

        while (true) {
            System.out.println("\nSimple Expense Tracker");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter date (dd/mm/yyyy): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.print("Invalid amount. Enter a valid amount: ");
                        scanner.next();
                    }
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    expenses.add(new Expense(date, desc, amount));
                    StoreExpense.SaveExpense(expenses);
                    System.out.println("Expense added successfully.");
                    break;
                case 2:
                    System.out.println("Expenses:");
                    for (Expense e : expenses) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}