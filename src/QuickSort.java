import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        QuickSortSolution test = new QuickSortSolution();

        int[] array = null;
        array = test.quickSort(array);
        System.out.println(Arrays.toString(array));


        array = new int[0];
        array = test.quickSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {1, 5, 2, 9};
        array = test.quickSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {1, 5, 2, 9, 9, 2};
        array = test.quickSort(array);
        System.out.print(Arrays.toString(array));
    }
}

/**
 * 2 5 1 7 9
 * i     j pivot
 *
 * [0, i) elements are smaller than pivot
 * (j, n -2] elements are larger than  pivot
 * [i, j] to be partition
 *
 * 1  5  3  9  (7)   --->    1  5  3  (7)  9   --> for each level, do partition O(n)
 *       j  i                    /       \         average case: have log(n) level when pivotValue divides array equally
 *                          1  (3) 5     9         worst case: have n levels when pivotValue is at the end of array
 *                            /   \                So time complexity: average case O(nlog(n)), worst case O(n^2)
 *                          1     5            --> Space complexity: average case: o(log(n)), worst case O(n)
 *
 */
class QuickSortSolution {
    public int[] quickSort(int[] array) {
        //corner case
        if (array == null || array.length <= 1) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;

    }

    //find pivotPos, and recursively solve left and right part
    private void quickSort(int[] array, int left, int right) {
        //base case
        //left == right means having 1 element; left>right means having no elements
        if (left >= right) {
            return;
        }
        int pivotPos = partition(array, left, right);
        quickSort(array, left, pivotPos - 1);
        quickSort(array, pivotPos + 1, right);
    }
    //swap pivotValue to its position and return pivotIdx
    private int partition(int[] array, int left, int right) {
        //randomly select a pivotValue
        Random rand = new Random();
        int pivotIdx = left + rand.nextInt(right - left + 1); //范围是左闭右开的
        int pivotValue = array[pivotIdx];
        //swap pivotValue to right most
        swap(array, pivotIdx, right);

        int i = left;
        int j = right - 1;

        //termination condition: when i > j
        while (i <= j) {
            if (array[i] >= pivotValue && array[j] < pivotValue) {
                swap(array, i, j);
                i++;
                j--;
            } else if (array[i] < pivotValue) {
                i++;
            } else {
                j--;
            }
        }
        //swap pivotValue to its right position'
        swap(array, i, right); //not swap with pivotIdx, because now pivotValue

        return i;

    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
