/* This is a class to using linear search to search item in an array.
 * @author Tao Guo
 */

package edu.usfca.cs.cs245;

public class LinearSearch implements Practice2Search {

	@Override
	//Return the name of the search
	public String searchName() {

		return "Linear Search";
	}

	@Override
	//Linear search methods
	public int search(int[] arr, int target) {

		for(int i = 0; i < arr.length; i++) {
			
			if(arr[i] == target) {
				return i;
			}
		}
		
		return -1;
	}

}
