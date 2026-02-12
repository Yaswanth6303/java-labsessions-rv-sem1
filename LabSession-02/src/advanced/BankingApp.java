package advanced;

import java.util.Scanner;

enum DepositType {
    UPI,
    IMPS,
    NEFT,
    CHEQUE
}

class BankApp {

    private final String accountHolderName;
    private final long accountNumber;
    private double balance;

    private static long nextAccountNumber = 1000000000L;

    public BankApp(String accountHolderName) {
        this(accountHolderName, 0);
    }

    public BankApp(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountNumber = nextAccountNumber++;
    }

    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Amount");
            return;
        }

        balance += amount;
        System.out.println("ATM Deposit Successful");
        System.out.println("Account Balance: " + balance);
    }

    void deposit(double amount, DepositType depositType) {
        if (amount <= 0) {
            System.out.println("Invalid Amount");
            return;
        }

        balance += amount;
        System.out.println("Deposit Type: " + depositType);
        System.out.println("Deposit Amount: " + amount);
        System.out.println("Account Balance: " + balance);
    }

    void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            System.out.println("Invalid or Insufficient Funds");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawn Amount: " + amount);
        System.out.println("Remaining Balance: " + balance);
    }

    void withdraw(double amount, String reason) {
        if (amount <= 0 || amount > balance) {
            System.out.println("Invalid or Insufficient Funds");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawn Amount: " + amount);
        System.out.println("Reason: " + reason);
        System.out.println("Remaining Balance: " + balance);
    }

    void showAccountDetails() {
        System.out.println("\nAccount Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

public class BankingApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Create Account");
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        double amount = readDouble(sc, "Enter Initial Amount: ");
        BankApp bankApp = new BankApp(name, amount);

        bankApp.showAccountDetails();

        while (true) {

            System.out.println("\nWelcome to our ATM");
            System.out.println("1. ATM Deposit");
            System.out.println("2. Online Deposit (UPI/IMPS/NEFT/CHEQUE)");
            System.out.println("3. ATM Withdrawal");
            System.out.println("4. Withdrawal with Reason");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = readInt(sc, "");

            switch (choice) {

                case 1 -> {
                    double amt = readDouble(sc, "Enter Deposit Amount: ");
                    bankApp.deposit(amt);
                }

                case 2 -> {
                    double amt = readDouble(sc, "Enter Deposit Amount: ");
                    sc.nextLine(); // clear buffer

                    DepositType type = readDepositType(sc);
                    bankApp.deposit(amt, type);
                }

                case 3 -> {
                    double amt = readDouble(sc, "Enter Withdrawal Amount: ");
                    bankApp.withdraw(amt);
                }

                case 4 -> {
                    double amt = readDouble(sc, "Enter Withdrawal Amount: ");
                    sc.nextLine();
                    System.out.print("Enter Withdrawal Reason: ");
                    String reason = sc.nextLine();
                    bankApp.withdraw(amt, reason);
                }

                case 5 -> {
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static double readDouble(Scanner sc, String message) {
        System.out.print(message);
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid input! Enter a valid number: ");
            sc.next();
        }
        return sc.nextDouble();
    }

    static int readInt(Scanner sc, String message) {
        if (!message.isEmpty()) {
            System.out.print(message);
        }
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input! Enter a number: ");
            sc.next();
        }
        return sc.nextInt();
    }

    static DepositType readDepositType(Scanner sc) {
        while (true) {
            System.out.print("Enter Deposit Type (UPI/IMPS/NEFT/CHEQUE): ");
            String input = sc.nextLine().toUpperCase();

            try {
                return DepositType.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Deposit Type! Try again.");
            }
        }
    }
}
