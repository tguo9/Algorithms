/* This is a class to using binary recursive to search item in an array.
 * @author Tao Guo
 */

package edu.usfca.cs.cs245;

public class BinaryRecursiveSearch implements Practice2Search {

	@Override
	// Return the name of the search
	public String searchName() {

		return "Binary Recursive Search";
	}

	// Binary Search Recursive version, helper method
	public int search(int[] arr, int target, int min, int max) {

		int mid;

		mid = (min + max) / 2;

		// Base case
		if (max < min) {
			return -1;
		}

		// Base case
		if (arr[mid] == target) {
			return mid;
		}

		// Step case
		if (target < arr[mid]) {
			return search(arr, target, min, mid - 1);
		} else {
			return search(arr, target, mid + 1, max);
		}
	}

	@Override
	/// Binary Search Recursive version, call helper method
	public int search(int[] arr, int target) {

		int min = 0;
		int max = arr.length - 1;

		return search(arr, target, min, max);
	}

}
