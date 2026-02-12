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

        while (true) {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = readInt(sc, "Enter age: ");
            sc.nextLine();

            System.out.print("Enter Designation: ");
            String designation = sc.nextLine();

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            Employee employee = new Employee(name, age, designation, department);
            employee.displayPersonalDetails();
            employee.displayOfficialDetails();
            System.out.println();

            // Correct validation for y/n
            String choice;
            while (true) {
                System.out.print("Do you want to enter another employee? (y/n): ");
                choice = sc.nextLine();

                if (choice.equalsIgnoreCase("y")) {
                    break;
                } else if (choice.equalsIgnoreCase("n")) {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                } else {
                    System.out.println("Invalid input! Please enter only 'y' or 'n'.");
                }
            }

            System.out.println();
        }
    }
}
