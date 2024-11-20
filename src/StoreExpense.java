import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StoreExpense {
    // Method to store expenses in a file
    private static final String FILENAME = "expenses.txt";

    // Method to save expenses to a file
    public static void SaveExpense(ArrayList<Expense> expenses) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (Expense e : expenses) {
                writer.println(e.getDate() + "," + e.getDesc() + "," + e.getAmount());
            }
        } catch (IOException e) {
            System.out.println("Error saving expenses to file: " + e.getMessage());
        }
    }

    // Method to load expenses from a file
    public static ArrayList<Expense> LoadExpenses() {
        ArrayList<Expense> expenses = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                expenses.add(new Expense(parts[0], parts[1], Double.parseDouble(parts[2])));
            }
        } catch (IOException e) {
            System.out.println("Error loading expenses from file: " + e.getMessage());
        }
        return expenses;
    }
}