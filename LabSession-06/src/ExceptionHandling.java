import java.util.Scanner;

class InvalidAgeException extends Exception {
	public InvalidAgeException(String message) {
		super(message);
	}
}

public class ExceptionHandling {

	public void validateAge(int age) throws InvalidAgeException {
		if (age >= 18) {
			System.out.println("Eligible for Voting");
		} else if (age <= 0) {
			throw new InvalidAgeException("Age cannot be negative");
		} else {
			throw new InvalidAgeException("Age is not eligible for voting");
		}
	}

	public int divideNumbers(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("b cannot be zero");
		}
		return a / b;
	}

	public void checkString(String str) {
		if (str == null) {
			throw new NullPointerException("String cannot be null");
		}
		System.out.println("Length of string: " + str.length());
	}

	public int convertStringToNumber(String input) {
		return Integer.parseInt(input);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ExceptionHandling obj = new ExceptionHandling();
		boolean running = true;

		while (running) {
			System.out.println("Exception Handling");
			System.out.println("1. Validate Age");
			System.out.println("2. Divide Numbers");
			System.out.println("3. Check String");
			System.out.println("4. Convert String to Number");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1 -> {
				try {
					System.out.print("Enter age: ");
					int age = sc.nextInt();
					obj.validateAge(age);
				} catch (InvalidAgeException e) {
					System.out.println("Custom Exception: " + e.getMessage());
				}
			}

			case 2 -> {
				try {
					System.out.print("Enter a: ");
					int a = sc.nextInt();
					System.out.print("Enter b: ");
					int b = sc.nextInt();
					System.out.println("Result: " + obj.divideNumbers(a, b));
				} catch (ArithmeticException e) {
					System.out.println("Arithmetic Exception: " + e.getMessage());
				}
			}

			case 3 -> {
				try {
					System.out.print("Enter a string (or type null): ");
					String str = sc.nextLine();
					if (str.equalsIgnoreCase("null")) {
						obj.checkString(null);
					} else {
						obj.checkString(str);
					}
				} catch (NullPointerException e) {
					System.out.println("NullPointer Exception: " + e.getMessage());
				}
			}

			case 4 -> {
				try {
					System.out.print("Enter a number in string format: ");
					String input = sc.nextLine();
					System.out.println("Converted Number: " + obj.convertStringToNumber(input));
				} catch (NumberFormatException e) {
					System.out.println("Number Format Exception: " + e.getMessage());
				}
			}

			case 5 -> {
				System.out.println("Exiting Program...");
				running = false;
			}

			default -> System.out.println("Invalid choice! Please select 1-5.");
			}
		}
		
		sc.close();
	}
}