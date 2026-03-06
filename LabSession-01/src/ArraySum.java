import java.util.Scanner;

public class ArraySum {
	public static int arraySum(int[] nums) {
		int n = nums.length;

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
		}

		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("Enter Number " + (i + 1) + ": ");
			nums[i] = sc.nextInt();
		}
		System.out.println("Sum of the Array is: " + arraySum(nums));

		sc.close();
	}
}