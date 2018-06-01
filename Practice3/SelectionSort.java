/* This is the algorithm for Selection Sort.
 * @author Tao Guo
 */

public class SelectionSort implements SortingAlgorithm {
	
	public int smallest(int[] a, int start) {
		int smallest = start;
		for(int i = start; i < a.length; i++) {
			if(a[i] < a[smallest]) {
				smallest = i;
			}
		}
		
		return smallest;
	}
	
	public void swap(int[] a, int i, int j) {
		
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void sort(int[] a) {
		for(int i = 0; i < a.length - 1; i++) {
			int smallest = smallest(a, i);
			swap(a, smallest, i);
		}

	}

}
