package question01;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Select Printer");
            System.out.println("1. Dot Matrix Printer");
            System.out.println("2. Laser Jet Printer");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input! Please enter only numbers: ");
                sc.next();
            }
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                	DotMatrix dotMatrix = new DotMatrix();
                	dotMatrix.configuration();
                	dotMatrix.display();
                	System.out.println();
                } 
                
                case 2 -> {
                	LaserJet laserJet = new LaserJet();
                	laserJet.configuration();
                	laserJet.display();
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
