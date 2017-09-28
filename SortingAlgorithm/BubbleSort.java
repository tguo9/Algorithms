/* This is the algorithm for Bubble Sort.
 * @author Tao Guo
 */

public class BubbleSort implements SortingAlgorithm {

	public void swap(int[] a, int i, int j) {
		
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void sort(int[] a) {
		
		for(int i = a.length - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				
				if(a[j] > a[j + 1]) {
					swap(a, j, j + 1);
				}
			}
		}	
	}
}
