import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        SelectionSortSolution test = new SelectionSortSolution();

        int[] array = null;
        array = test.sortArray(array);
        System.out.print(Arrays.toString(array));
        System.out.println();

        //不断地改写array
        array = new int[] {};
        array = test.sortArray(array);
        System.out.print(Arrays.toString(array));
        System.out.println();

        array = new int[] {3, 6, 1, 7};
        array = test.sortArray(array);
        System.out.print(Arrays.toString(array));
        System.out.println();

        array = new int[] {3, 6, 1, 7, 7, 3};
        array= test.sortArray(array);
        System.out.print(Arrays.toString(array));
    }
}

/**
 * 2 5 6 1
 * i
 *   j
 *
 * [0, i) sorted
 * [i, n - 1] sorted
 *
 * 1. initialize:  int i = 0, int j = i + 1
 * 2. termination condition: i < array.length - 1
 * 3. for each step:
 *      i traverses [0, n - 1]             O(n)
 *      j traverses [i + 1, n - 1]         O(n)
 *      globalMin = array[i]
 *      if array[j] < globalMin --> globalMin = array[j]    O(1)
 *      else do nothing
 *    swap array[i] and globalMin
 *
 * 4. Time complexity = O(n^2)
 *    Space compleity = O(1)
 */



class SelectionSortSolution {
    public int[] sortArray(int[] array) {
        //corner case
        if (array == null || array.length <= 1) {
            return array;
        }

        //get out of the loop when i is at the last but one    O(n)
        for (int i = 0; i < array.length - 1; i++) {
            int globalMinIdx = i; //注意globalMin是等于index还是array[index] 前后要统一

            //to find globalMin    O(n)
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[globalMinIdx]) {
                    globalMinIdx = j;
                }
            }
            swap(array, i, globalMinIdx); // O(1)
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

/** SUMMARY
 * 1. 注意维护的是array里面的最小值，还是最小值的index，前后要一致
 * 2. 觉得维护index更方便，因为之后要swap，可以直接用到index
 * 3. corner case 必须handle array == null， array.length == 0 不check也没事
 * 4. corner case array.length <= 1 is better than == 0
 */
