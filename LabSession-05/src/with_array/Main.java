package with_array;

import java.util.Scanner;

public class Main {
	public static int readInt(Scanner sc, String message) {
		System.out.print(message);
		while (!sc.hasNextInt()) {
			System.out.println("Invalid input! Age must be a number.");
			System.out.print("Enter Age again: ");
			sc.next();
		}
		
		return sc.nextInt();
	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = readInt(sc, "Enter number of Employees: ");
        sc.nextLine(); 

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Employee");

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            int age = readInt(sc, "Enter age: ");
            sc.nextLine();

            System.out.print("Enter Designation: ");
            String designation = sc.nextLine();

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            employees[i] = new Employee(name, age, designation, department);

            employees[i].displayPersonalDetails();
            employees[i].displayOfficialDetails();

            System.out.println();
        }

        System.out.println("All employees have been added.");
        sc.close();
    }
}
