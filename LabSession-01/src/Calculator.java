import java.util.Scanner;

public class Calculator {

    private final double a;
    private double b;
    private static double result;

    Calculator(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public void add() {
        result = a + b;
        System.out.println("Sum of " + a + " and " + b + " is: " + result);
    }

    public void sub() {
        result = a - b;
        System.out.println("Subtraction of " + a + " and " + b + " is: " + result);
    }

    public void mul() {
        result = a * b;
        System.out.println("Multiplication of " + a + " and " + b + " is: " + result);
    }

    public void div(Scanner sc) {
        while (b == 0) {
            System.out.println("Denominator cannot be 0.");
            b = readDouble(sc, "Enter the denominator: ");
        }

        result = a / b;
        System.out.println("Division of " + a + " and " + b + " is: " + result);
    }

    static double readDouble(Scanner sc, String message) {
        System.out.print(message);

        while (!sc.hasNextDouble()) {
            System.out.print("Invalid input! Enter a valid number: ");
            sc.next();  
        }

        return sc.nextDouble();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.println("\nCalculator App");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");

            System.out.println("Enter your choice:");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice! Please enter a number between 1 and 5.");
                sc.next();
            }

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    double a = readDouble(sc, "Enter a: ");
                    double b = readDouble(sc, "Enter b: ");
                    new Calculator(a, b).add();
                }
                case 2 -> {
                    double a = readDouble(sc, "Enter a: ");
                    double b = readDouble(sc, "Enter b: ");
                    new Calculator(a, b).sub();
                }
                case 3 -> {
                    double a = readDouble(sc, "Enter a: ");
                    double b = readDouble(sc, "Enter b: ");
                    new Calculator(a, b).mul();
                }
                case 4 -> {
                    double a = readDouble(sc, "Enter a: ");
                    double b = readDouble(sc, "Enter b: ");
                    new Calculator(a, b).div(sc);
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    running = false;
                }
                default -> System.out.println("Please choose a valid option (1-5).");
            }
        }

        sc.close();
    }
}
