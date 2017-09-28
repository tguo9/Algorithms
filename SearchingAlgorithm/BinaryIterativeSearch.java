/* This is a class to using binary iterative to search item in an array.
 * @author Tao Guo
 */

package edu.usfca.cs.cs245;

public class BinaryIterativeSearch implements Practice2Search {

	@Override
	//Return the name of the search
	public String searchName() {

		return "Binary Iterative Search";
	}

	@Override
	//Binary Search Iterative version
	public int search(int[] arr, int target) {
		int min = 0;
		int max = arr.length - 1;
		int mid;
		
		while(min <= max) {
			
			if(max % 2 == 0) {
				mid = (min + max) / 2;
			} else {
				mid = (min + max + 1) / 2;
			}
			
			if(arr[mid] == target) {
				
				return mid;
			}
			
			if(arr[mid] - target < 0) {
				min = mid + 1;
			} else {
				max = mid -1;
			}
		}
		return -1;
	}

}