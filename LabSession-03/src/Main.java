import java.util.Scanner;
import shape.Square;
import shape.Circle;
import shape.Triangle;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean running = true;

		while (running) {
			System.out.println("Area Calculator");
			System.out.println("1. Square");
			System.out.println("2. Circle");
			System.out.println("3. Triangle");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");

			int choice = readInt(sc, "Enter a choice: ");

			switch (choice) {
			case 1 -> {
				double side = readDouble(sc, "Enter side of square: ");
				Square sq = new Square(side);
				System.out.println("Area of Square: " + sq.area());
			}

			case 2 -> {
				double radius = readDouble(sc, "Enter radius of circle: ");
				Circle cr = new Circle(radius);
				System.out.println("Area of Circle: " + cr.area());
			}

			case 3 -> {
				double base = readDouble(sc, "Enter base of triangle: ");
				double height = readDouble(sc, "Enter height of triangle: ");
				Triangle tr = new Triangle(base, height);
				System.out.println("Area of Triangle: " + tr.area());
			}

			case 4 -> {
				System.out.println("Exiting program...");
				running = false;
			}

			default -> System.out.println("Invalid choice! Please try again.");
			}
		}

		sc.close();
	}

	private static double readDouble(Scanner sc, String message) {
		System.out.print(message);
		while (!sc.hasNextDouble()) {
			System.out.print("Invalid input! Please enter a valid number: ");
			sc.next();
		}
		return sc.nextDouble();
	}
	
	private static int readInt(Scanner sc, String message) {
		System.out.print(message);
		while (!sc.hasNextInt()) {
			System.out.print("Invalid input! Please enter a valid number: ");
			sc.next();
		}
		return sc.nextInt();
	}
}
