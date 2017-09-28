/* This is the algorithm for Merge Sort.
 * @author Tao Guo
 */

public class MergeSort implements SortingAlgorithm {

    private int[] temp;

    public void sort(int[] a) {
        int index = a.length;
        temp = new int[index];
        sort(a, 0, index - 1);
    }

    public void sort(int[] a, int top, int bot) {
        
        if (top < bot) {
           
            int mid = (top + bot) / 2;
           
            sort(a, top, mid);

            sort(a, mid + 1, bot);

            sort(a, top, mid, bot);
        }
    }

    public void sort(int[] a, int top, int mid, int bot) {

        for (int i = top; i <= bot; i++) {
            temp[i] = a[i];
        }

        int topIndex = top;
        int midIndex = mid + 1;
        int botIndex = top;
        
        while (topIndex <= mid && midIndex <= bot) {
            if (temp[topIndex] <= temp[midIndex]) {
                a[botIndex] = temp[topIndex];
                topIndex++;
            } else {
                a[botIndex] = temp[midIndex];
                midIndex++;
            }
            botIndex++;
        }
        
        while (topIndex <= mid) {
            a[botIndex] = temp[topIndex];
            botIndex++;
            topIndex++;
        }
    }

}
