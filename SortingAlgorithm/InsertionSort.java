/* This is the algorithm for Insertion Sort.
 * @author Tao Guo
 */

public class InsertionSort implements SortingAlgorithm {

	public void sort(int[] a) {
		
		for(int i = 1; i < a.length; i++) {
			
			int temp = a[i];
			
			int j = i - 1;
			
			while(j >= 0 && temp < a[j]) {
				
				a[j + 1] = a[j];
				j--;
			}
			
			a[j + 1] = temp;
		}
	}

}
