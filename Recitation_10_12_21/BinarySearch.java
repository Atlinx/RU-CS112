package Recitation_10_12_21;

import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args) {
		int[] array = new int[] { -1, 0, 3, 5, 9, 12 };
		System.out.println("Array: " + Arrays.toString(array));
		printSearch(9, array);
		printSearch(5, array);
		printSearch(1, array);
		printSearch(12, array);
		printSearch(11, array);
	}

	public static void printSearch(int target, int[] array) {
		System.out.println("Search for " + target + ": " + search(target, array));
	}

	public static int search(int target, int[] array) {
		int low = 0;
		int high = array.length - 1;
		int mid;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (target > array[mid])
				low = mid + 1;
			else if (target < array[mid])
				high = mid - 1;
			else
				return mid;
		}
		return -1;
	}

	public static void drawDecisionTree(int[] array) {
		
	}
}