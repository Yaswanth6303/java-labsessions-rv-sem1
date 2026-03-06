package trycatch;

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

class ArrayStorage<E> {
	private E[] array;

	public ArrayStorage(E[] array) {
		this.array = array;
	}

	public void printArray() {
		for (E element : array) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}

public class Generics {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean running = true;

		while (running) {
			try {
				System.out.println("GENERICS DEMO");
				System.out.println("1. Store Integer");
				System.out.println("2. Store String");
				System.out.println("3. Print Integer Array");
				System.out.println("4. Print String Array");
				System.out.println("5. Print Double Array");
				System.out.println("6. Exit");
				System.out.print("Enter your choice: ");

				int choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {

				case 1 -> {
					System.out.print("Enter Integer value: ");
					int value = sc.nextInt();
					Storage<Integer> s = new Storage<>();
					s.setItem(value);
					System.out.println("Stored Integer: " + s.getItem());
				}

				case 2 -> {
					System.out.print("Enter String value: ");
					Storage<String> s = new Storage<>();
					s.setItem(sc.nextLine());
					System.out.println("Stored String: " + s.getItem());
				}

				case 3 -> {
					System.out.print("Enter size of Integer array: ");
					int n = sc.nextInt();
					Integer[] array = new Integer[n];

					System.out.println("Enter Integer elements:");
					for (int i = 0; i < n; i++) {
						array[i] = sc.nextInt();
					}

					ArrayStorage<Integer> obj = new ArrayStorage<>(array);
					System.out.print("Integer Array: ");
					obj.printArray();
				}

				case 4 -> {
					System.out.print("Enter size of String array: ");
					int n = sc.nextInt();
					sc.nextLine();

					String[] array = new String[n];
					System.out.println("Enter String elements:");
					for (int i = 0; i < n; i++) {
						array[i] = sc.nextLine();
					}

					ArrayStorage<String> obj = new ArrayStorage<>(array);
					System.out.print("String Array: ");
					obj.printArray();
				}

				case 5 -> {
					System.out.print("Enter size of Double array: ");
					int n = sc.nextInt();
					Double[] array = new Double[n];

					System.out.println("Enter Double elements:");
					for (int i = 0; i < n; i++) {
						array[i] = sc.nextDouble();
					}

					ArrayStorage<Double> obj = new ArrayStorage<>(array);
					System.out.print("Double Array: ");
					obj.printArray();
				}

				case 6 -> {
					System.out.println("Exiting...");
					running = false;
				}

				default -> System.out.println("Invalid choice!");
				}

			} catch (Exception e) {
				System.out.println("Invalid input! Please enter correct data.");
				sc.nextLine();
			}
		}
		sc.close();
	}
}
