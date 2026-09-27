package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    double[] transactions = new double[1000];
    int transactionCount = 0;

    public BankAccount(String name, int startingBalance){
        this.name = name;
        this.currentBalance = startingBalance;
    }

    public void deposit(double amount){
        if (amount < 0) {
            System.out.println("Cannot deposit a negative amount of money");
        } else {
            currentBalance += amount;
            if (transactionCount < transactions.length) {
                transactions[transactionCount] = amount;
                transactionCount++;
            }
        }
        System.out.println(name + " deposited $" + amount + ". New balance: $" + currentBalance);
    }

    public void withdraw(double amount){
        if (amount < 0) {
            System.out.println("Cannot withdraw a negative amount of money");
        } else if (amount > currentBalance) {
            System.out.println("Insufficient balance for withdrawal of $" + amount);
        } else {
            currentBalance -= amount;
            if (transactionCount < transactions.length) {
                transactions[transactionCount] = -amount;
                transactionCount++;
            }
            System.out.println(name + " withdrew $" + amount + ". New balance: $" + currentBalance);
        }
    }

    public void displayTransactions(){
        if (transactionCount == 0) {
            System.out.println("No transactions recorded.");
            return;
        }

        for (int i = 0; i < transactionCount; i++) {
            System.out.println("Transaction " + (i + 1) + ": " + transactions[i]);
        }
    }

    public void displayBalance(){
        System.out.println("Current balance for " + name + ": $" + currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
