import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

//Assumption: k >= 0, array is not null
public class KSmallestInUnsortedArray {
    public static void main(String[] args) {
        int[] array = {1, 3, 9, 0, 2, 5, 5};
        int k = 0;
        int[] res = kSmallest(array, k);
        for (int x : res) {
            System.out.print(x + " ");
        }
    }

    public static int[] kSmallest(int[] array, int k) {
        int[] result = new int[k];
        //corner case
        if (k == 0) {
            return result;
        }

        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        //pretent to heapify
        for (int i = 0; i < k; i++) {
            maxHeap.offer(array[i]);       //if no corner case check, here will throw NPE
        }
        //iterate the rest of elements in array
        for (int i = k; i < array.length; i++) {
            if (maxHeap.peek() > array[i]) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
}
