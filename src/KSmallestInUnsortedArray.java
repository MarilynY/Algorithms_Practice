import java.util.*;
import static java.util.Arrays.copyOfRange;

//Assumption: k >= 0, array != null, k <= array.length
public class KSmallestInUnsortedArray {
    public static void main(String[] args) {
        int[] array = {3, 1, 5, 2, 4, 0};
        int k = 1;
        KSmallestInUnsortedArraySolution test = new KSmallestInUnsortedArraySolution();
        int[] res = test.kSmallest(array, k);
        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}
//Method 2： quickSelect
class KSmallestInUnsortedArraySolution {
    public int[] kSmallest(int[] array, int k) {
        // Write your solution here
        if (k == 0) {
            return new int[0];
        }
        findKSmallest(array, k, 0, array.length - 1);
        Arrays.sort(array, 0, k); //keep in mind   左闭右开 k+1会导致index out of bound when {1}， 1
        return Arrays.copyOfRange(array,0, k); //not ascending order yet   [0, k)
    }

    private void findKSmallest(int[] array, int k, int left, int right) {
        //base case
        //stop searching when no elements
        if (left > right) { // left == right 的时候还有一个元素需要看，不能停下来
            return;
        }
        //current layer
        int pivotPosition = quickSelect(array, left, right);
        if (pivotPosition == k || pivotPosition == k - 1) {
            return;
        }
        //Recursion
        if (pivotPosition > k) {
            findKSmallest(array, k, left, pivotPosition - 1);
        }
        if (pivotPosition < k) {
            findKSmallest(array, k, pivotPosition + 1, right);
        }
    }
    private int quickSelect(int[] array, int left, int right) {
        //random select an element
        Random rand = new Random();
        int pivotIndex = left + rand.nextInt(right - left + 1);
        int pivotValue = array[pivotIndex];
        //swap the pivot to the right most
        swap(array, pivotIndex, array.length - 1);
        //two pointers
        //1 3 5 2
        //l     r
        //i   j
        int i = left;
        int j = right - 1;
        while (i <= j) {
            if (array[i] < pivotValue) {
                i++;
            } else if (array[j] >= pivotValue) {
                j--;
            } else {
                swap(array, i++, j--);
            }
        }
        //put pivotValue to its position
        swap(array, array.length - 1, i);
        return i;
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

//    Method1:Maintain a maxHeap
//    public static int[] kSmallest(int[] array, int k) {
//        int[] result = new int[k];
//        //corner case
//        if (k == 0) {
//            return result;
//        }
//
//        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
//        //pretent to heapify
//        for (int i = 0; i < k; i++) {
//            maxHeap.offer(array[i]);       //if no corner case check, here will throw NPE
//        }
//        //iterate the rest of elements in array
//        for (int i = k; i < array.length; i++) {
//            if (maxHeap.peek() > array[i]) {
//                maxHeap.poll();
//                maxHeap.offer(array[i]);
//            }
//        }
//        for (int i = k - 1; i >= 0; i--) {
//            result[i] = maxHeap.poll();
//        }
//        return result;
//     }