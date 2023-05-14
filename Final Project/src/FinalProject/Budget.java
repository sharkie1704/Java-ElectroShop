package FinalProject;

public class Budget {

    private double balance;

    /*
    Constructor
    */
    public Budget(double balance) {
        this.balance = balance;
    }

    // add money
    public void add(double amount) {
        balance += amount;
    }

    // remove money
    public void remove(double amount) {
        balance -= amount;
    }

    // display balance
    public void displayBalance() {
        System.out.println("Current balance: $" + String.format("%.2f", balance));
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
