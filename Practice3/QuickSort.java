/* This is the algorithm for Quick Sort.
 * @author Tao Guo
 * Reference from qs.java
 */


public class QuickSort implements SortingAlgorithm {
	
	public void sort(int[] a) {
		
		sort(a, 0, a.length - 1);
	}
	
	public void swap(int[] a, int i, int j) {
		
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void sort(int a[], int top, int bot) {
		
		 if (top <= bot - 1) {
			 int j = partition(a, top, bot);
			 sort(a, top, j - 1);
			 sort(a, j + 1, bot);
		 } else {
			 return;
		 }
	}
	 
	 public int partition(int [] a, int top, int bot) {
		
		int i = top;                         
        int j = bot;
        
        int pivot = a[top];       

        while (i < j) {
            while (a[i] <= pivot && j > i && i <= bot) {
            		i++;
            }  
                                                     
            while (a[j] > pivot && j >= top && j >= i) {
            		j--;
            } 
                                                     
            if (i < j){
            		swap(a, i, j);
            }                                 
        }
        swap(a, top, j);                         

        return j;
	}
}
