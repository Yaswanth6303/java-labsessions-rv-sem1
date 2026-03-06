import java.util.Scanner;

class Storage<T> {
	private T item;

	public void setItem(T item) {
		this.item = item;
	}

	public T getItem() {
		return item;
	}
}

public class Generics {

	public static <E> void printArray(E[] array) {
		for (E element : array) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean running = true;

		while (running) {

			System.out.println("Generics");
			System.out.println("1. Store Integer");
			System.out.println("2. Store String");
			System.out.println("3. Print Integer Array");
			System.out.println("4. Print String Array");
			System.out.println("5. Print Double Array");
			System.out.println("6. Exit");

			System.out.print("Enter your choice: ");
			int choice = readInt(sc);
			sc.nextLine();

			switch (choice) {

			case 1 -> {
				System.out.print("Enter Integer value: ");
				int value = readInt(sc);

				Storage<Integer> s = new Storage<>();
				s.setItem(value);

				System.out.println("Stored Integer: " + s.getItem());
			}

			case 2 -> {
				System.out.print("Enter String value: ");
				String value = sc.nextLine();

				Storage<String> s = new Storage<>();
				s.setItem(value);

				System.out.println("Stored String: " + s.getItem());
			}

			case 3 -> {
				System.out.print("Enter size of Integer array: ");
				int n = readInt(sc);

				Integer[] array = new Integer[n];

				System.out.println("Enter Integer elements:");
				for (int i = 0; i < n; i++) {
					System.out.print("Element " + (i + 1) + ": ");
					array[i] = readInt(sc);
				}

				System.out.print("Integer Array: ");
				printArray(array);
			}

			case 4 -> {
				System.out.print("Enter size of String array: ");
				int n = readInt(sc);
				sc.nextLine();

				String[] array = new String[n];

				System.out.println("Enter String elements:");
				for (int i = 0; i < n; i++) {
					System.out.print("Element " + (i + 1) + ": ");
					array[i] = sc.nextLine();
				}

				System.out.print("String Array: ");
				printArray(array);
			}

			case 5 -> {
				System.out.print("Enter size of Double array: ");
				int n = readInt(sc);

				Double[] array = new Double[n];

				System.out.println("Enter Double elements:");
				for (int i = 0; i < n; i++) {
					System.out.print("Element " + (i + 1) + ": ");
					array[i] = readDouble(sc);
				}

				System.out.print("Double Array: ");
				printArray(array);
			}

			case 6 -> {
				System.out.println("Exiting...");
				running = false;
			}

			default -> System.out.println("Invalid choice! Please select 1-6.");
			}
		}

		sc.close();
	}

	public static int readInt(Scanner sc) {
		while (!sc.hasNextInt()) {
			System.out.println("Invalid input! Enter a valid integer:");
			sc.next();
		}
		return sc.nextInt();
	}

	public static double readDouble(Scanner sc) {
		while (!sc.hasNextDouble()) {
			System.out.println("Invalid input! Enter a valid double:");
			sc.next();
		}
		return sc.nextDouble();
	}
}
