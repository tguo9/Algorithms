/* This is a class to using binary recursive to search item in an array.
 * @author Tao Guo
 */

package edu.usfca.cs.cs245;

public class BinaryRecursiveSearch implements Practice2Search {
	
	@Override
	//Return the name of the search
	public String searchName() {
		
		return "Binary Recursive Search";
	}

	//Binary Search Recursive version, helper method
	public int search(int[] arr, int target, int min, int max) {
		
		int mid;
		
		if(max % 2 == 0) {
			mid = (min + max) / 2;
		} else {
			mid = (min + max + 1) / 2;
		}
		
		//Base case
		if(max < min) {
			return -1;
		}
		
		//"Ideal" case
		if(arr[mid] == target) {
			return mid;
		}
		
		//Step case
		if(arr[mid] - target < 0) {
			return search(arr, target, min, mid - 1);
		} else {
			return search(arr, target, mid + 1, max);
		}
	}
	
	@Override
	///Binary Search Recursive version, call helper method
	public int search(int[] arr, int target) {
		
		int min = 0;
		int max = arr.length - 1;
		
		return search(arr, target, min, max);
	}
	
	

}
