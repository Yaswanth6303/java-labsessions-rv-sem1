package advanced;

import java.util.Scanner;
import java.util.function.Function;

class InputUtil {
	public static <T> T readInput(Scanner sc, String message, Function<String, T> parser) {
		System.out.print(message);
		while (true) {
			try {
				return parser.apply(sc.nextLine());
			} catch (Exception e) {
				System.out.print("Invalid input! Try again: ");
			}
		}
	}
}

class ArrayUtil {
	public static <T> T[] readArray(Scanner sc, int size, Function<String, T> parser, T[] array) {
		for (int i = 0; i < size; i++) {
			while (true) {
				try {
					System.out.print("Enter element " + (i + 1) + ": ");
					array[i] = parser.apply(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("Invalid input! Try again.");
				}
			}
		}
		return array;
	}
}

class Storage<T> {
	private T obj;

	public void setObj(T obj) {
		this.obj = obj;
	}

	public T getObj() {
		return obj;
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

		System.out.println("Generics");
		System.out.println("1. Store Integer");
		System.out.println("2. Store String");
		System.out.println("3. Print Integer Array");
		System.out.println("4. Print String Array");
		System.out.println("5. Print Double Array");
		System.out.println("6. Exit");
		System.out.print("Enter your choice: ");

		int choice = Integer.parseInt(sc.nextLine());

		switch (choice) {

		case 1 -> {
			Integer value = InputUtil.readInput(sc, "Enter Integer value: ", Integer::parseInt);
			Storage<Integer> intStorage = new Storage<>();
			intStorage.setObj(value);
			System.out.println("Stored Integer: " + intStorage.getObj());
		}

		case 2 -> {
			String value = InputUtil.readInput(sc, "Enter String value: ", s -> s);
			Storage<String> stringStorage = new Storage<>();
			stringStorage.setObj(value);
			System.out.println("Stored String: " + stringStorage.getObj());
		}

		case 3 -> {
			System.out.print("Enter array size: ");
			int size = Integer.parseInt(sc.nextLine());

			Integer[] intArray = new Integer[size];
			ArrayUtil.readArray(sc, size, Integer::parseInt, intArray);

			System.out.print("Integer Array: ");
			printArray(intArray);
		}

		case 4 -> {
			System.out.print("Enter array size: ");
			int size = Integer.parseInt(sc.nextLine());

			String[] stringArray = new String[size];
			ArrayUtil.readArray(sc, size, s -> s, stringArray);

			System.out.print("String Array: ");
			printArray(stringArray);
		}

		case 5 -> {
			System.out.print("Enter array size: ");
			int size = Integer.parseInt(sc.nextLine());

			Double[] doubleArray = new Double[size];
			ArrayUtil.readArray(sc, size, Double::parseDouble, doubleArray);

			System.out.print("Double Array: ");
			printArray(doubleArray);
		}

		default -> System.out.println("Invalid choice!");
		}

		sc.close();
	}
}
