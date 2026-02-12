import java.util.Scanner;

public class BankApp {

    private final long accountNumber;
    private final String name;
    private double totalAmount;

    private static long nextAccountNumber = 1000000000L;

    BankApp(String name) {
        this.name = name;
        this.accountNumber = nextAccountNumber;
    }

    BankApp(String name, double amount) {
        this.name = name;
        this.totalAmount = amount;
        this.accountNumber = nextAccountNumber++;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            totalAmount += amount;
            System.out.println("Bank Deposit Successful");
            System.out.println("Total Amount: " + totalAmount);
        } else {
            System.out.println("Invalid Amount");
        }
    }

    public void deposit(double amount, String depositType) {
        if (amount > 0) {
            totalAmount += amount;
            System.out.println("Deposit Type: " + depositType);
            System.out.println("Total Amount: " + totalAmount);
        } else {
            System.out.println("Invalid Amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > totalAmount) {
            System.out.println("Insufficient Funds");
        } else if (amount <= 0) {
            System.out.println("Invalid Amount");
        } else {
            totalAmount -= amount;
            System.out.println("Withdraw Successful");
            System.out.println("Remaining Amount: " + totalAmount);
        }
    }

    public void withdraw(double amount, String reason) {
        if (amount > totalAmount) {
            System.out.println("Insufficient Funds");
        } else if (amount <= 0) {
            System.out.println("Invalid Amount");
        } else {
            totalAmount -= amount;
            System.out.println("Withdraw Successful");
            System.out.println("Reason: " + reason);
            System.out.println("Remaining Amount: " + totalAmount);
        }
    }

    public void showAccountDetails() {
        System.out.println("\nAccount Holder: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + totalAmount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Create Account");
        System.out.println("1. With Balance");
        System.out.println("2. Zero Balance");

        BankApp bankApp;
        int input = readInt(sc, "Enter choice: ");

        if (input == 1) {
            sc.nextLine();
            System.out.print("Enter Account Holder Name: ");
            String name = sc.nextLine();
            double amount = readDouble(sc, "Enter Initial Amount: ");
            bankApp = new BankApp(name, amount);
        } else if (input == 2) {
            sc.nextLine();
            System.out.print("Enter Account Holder Name: ");
            String name = sc.nextLine();
            bankApp = new BankApp(name);
        } else {
            System.out.println("Invalid choice. Exiting...");
            sc.close();
            return;
        }

        bankApp.showAccountDetails();
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to Bank Application");
            System.out.println("1. ATM Deposit");
            System.out.println("2. Deposit (UPI/IMPS/NEFT/CHEQUE)");
            System.out.println("3. ATM Withdraw");
            System.out.println("4. Withdrawal with Reason");
            System.out.println("5. Account Details");
            System.out.println("6. Exit");

            int choice = readInt(sc, "Enter choice: ");

            switch (choice) {
                case 1 -> {
                    double amt = readDouble(sc, "Enter amount: ");
                    bankApp.deposit(amt);
                }
                case 2 -> {
                    double amt = readDouble(sc, "Enter amount: ");
                    sc.nextLine();
                    System.out.print("Enter Deposit Type(UPI/IMPS/NEFT/CHEQUE): ");
                    String type = sc.nextLine();
                    bankApp.deposit(amt, type);
                }
                case 3 -> {
                    double amt = readDouble(sc, "Enter amount: ");
                    bankApp.withdraw(amt);
                }

                case 4 -> {
                    double amt = readDouble(sc, "Enter amount: ");
                    sc.nextLine();
                    System.out.print("Enter Withdrawal Reason: ");
                    String reason = sc.nextLine();
                    bankApp.withdraw(amt, reason);
                }

                case 5 -> bankApp.showAccountDetails();

                case 6 -> {
                    System.out.println("Exiting...");
                    running = false;
                }

                default -> System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }

    static double readDouble(Scanner sc, String message) {
        System.out.print(message);
        while (!sc.hasNextDouble()) {
            System.out.println("Invalid Input! Enter a valid number");
            sc.next();
        }
        return sc.nextDouble();
    }

    static int readInt(Scanner sc, String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            System.out.println("Invalid Input! Enter a valid number");
            sc.next();
        }
        return sc.nextInt();
    }
}