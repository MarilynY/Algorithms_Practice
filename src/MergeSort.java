import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        MergeSortSolution test = new MergeSortSolution();

        int[] array = null;
        array = test.mergeSort(array);
        System.out.println(Arrays.toString(array));


        array = new int[0];
        array = test.mergeSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {1, 5, 2, 9};
        array = test.mergeSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {1, 5, 2, 9, 9, 2};
        array = test.mergeSort(array);
        System.out.print(Arrays.toString(array));
    }
}


/**
 * 1. split array equally until it cannot be split anymore(find mid)
 * 2. merge by using helper array
 * 3.                       [3, 7, 1, 0, 2, 6]
 *
 *                                  |
 *                         [3, 7, 1, | 0, 2, 6]                          split process(find mid)
 *                           /         \                                 Time = O(n) number of nodes of last layer
 *                     [3, | 7, 1]      [0, | 2, 6]                      Space = O(logn) for call stack
 *                      /    \        /      \
 *                   [3]    [7, | 1]   [0]   [2,| 6]
 *              =============================================
 *                    |      \    /      |    \   /                       merge process(who small move who)
 *                   [3]    [1, 7]     [0]   [2, 6]  -- O(n)              Time: On for each layer,and logn layer
 *                      \     /           \     /    -- O(n)                    O(nlogn)
 *                     [1, 3, 7]        [0, 2, 6]    -- O(n)              Space: O(n+logn) for heap and call stack
 *                             \          /
 *                         [0, 1, 2, 3, 6, 7]                             So total time: O(nlogn)
 *                                                                           total space: O(n)
 *
 */

//Method 2 more clear

class MergeSortSolution {
    public int[] mergeSort(int[] array) {
        //corner case
        if (array == null || array.length <= 1) {
            return array;
        }
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);//勿忘-1
        return array;
    }
    //split
    private void mergeSort(int[] array, int[] helper, int left, int right) {
        //base case
        if (left >= right) {
            return;
        }
        //logic
        int mid = left + (right - left) / 2;

        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid + 1, right);
        merge(array, helper, mid, left, right);
    }
    //merge
    private void merge(int[] array, int[] helper, int mid, int left, int right) {
        //int[] helper = new int[array.length];
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }
        int i = left;
        int j = mid + 1;
        //termination condition: when i > mid or j > right
        while (i <= mid && j <= right) {
            if (helper[i] < helper[j]) {
                array[left++] = helper[i++];
            } else {
                array[left++] = helper[j++];
            }
        }
        //if left side still has elements, copy to original array
        //if right side still has elements, do nothing
        while (i <= mid) {
            array[left++] = helper[i++];
        }
    }
}

//Method 1
//class MergeSortSolution {
//    public int[] mergeSort(int[] array) {
//        //corner case
//        if (array == null || array.length <= 1) {
//            return array;
//        }
//        merge(array, 0, array.length - 1);
//        return array;
//    }
//
//    private void merge(int[] array, int left, int right) {
//        //base case
//        if (left >= right) {
//            return;
//        }
//        //logic
//        int mid = left + (right - left) / 2;
//        //recursion
//        merge(array, left, mid);
//        merge(array, mid + 1, right);
//
//        //Split
//        /*=============================================*/
//        //Merge
//
//        //use helper Array
//        int[] helper = new int[array.length];
//        for (int i = left; i <= right; i++) { // <= not <
//            helper[i] = array[i];
//        }
//
//        int i = left;
//        int j = mid + 1;
//        //int k = 0; wrong index == left
//        //termination condition: 一边走完就停止
//
//        while (i <= mid && j <= right) { //not ||
//            if (helper[i] < helper[j]) {
//                array[left++] = helper[i++];
//            } else {
//                array[left++] = helper[j++];
//            }
//        }
//
//        //if elements left in the left array, copy them to original array
//        //if elements left in the right array, do nothing
//        while (i <= mid) {
//            array[left++] = helper[i++];
//        }
//    }
//}

