public class Expense {

    // Making variables private to prevent direct access
    private String date;
    private String desc;
    private double amount;

    public Expense(String date, String desc, double amount) {
        this.date = date;
        this.desc = desc;
        this.amount = amount;
    }

    // Getters and Setters
    public String getDate() {
        return date;
    }

    public String getDesc() {
        return desc;
    }

    public double getAmount() {
        return amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "date='" + date + '\'' +
                ", desc='" + desc + '\'' +
                ", amount=" + amount +
                '}';
    }
}