package question02a;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean running = true;

        while (running) {
            System.out.println("Pick Vehicle");
            System.out.println("1. Car");
            System.out.println("2. Motorcycle");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input! Please enter only numbers: ");
                sc.next();
            }
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                	Vehicle car = new Car();
                	car.drive();
                	System.out.println();
                } 
                
                case 2 -> {
                	Vehicle motorcycle = new Motorcycle();
                	motorcycle.drive();
                	System.out.println();
                }
                
                case 3 -> {
                	System.out.println("Exiting...");
                	running = false;
                }

                default -> System.out.println("Invalid choice! Please try again.");
                
            }
        }

        sc.close();
	}
}
