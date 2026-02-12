public class LargestNumber {
	public static int maxElement(int[] nums) {
		int n = nums.length;

		int maxElement = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (nums[i] > maxElement) {
				maxElement = nums[i];
			}
		}

		return maxElement;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		System.out.println("Largest Number: " + maxElement(nums));
	}
}