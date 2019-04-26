import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        MergeSortSolution2 test = new MergeSortSolution2();

        int[] array1 = null;
        int[] array2 = null;
        int[] result = test.merge(array1, array2);
        System.out.println(Arrays.toString(result));

        array1 = null;
        int[] array3 = {1, 2};
        result = test.merge(array1, array3);
        System.out.println(Arrays.toString(result));

        array3 = new int[] {2, 3};
        array1 = null;
        result = test.merge(array1, array3);
        System.out.println(Arrays.toString(result));

        array3 = new int[] {3, 4};
        int[] array4 = {1, 2};
        result = test.merge(array4, array3);
        System.out.println(Arrays.toString(result));

    }
}


//Two sorted array, who small move who
//two pointers
//1. initialize: int i = one[0], int j = two[0]
//2. termination condition: when i > one.length or j > two.length
//3. for each step: if (one[i] < two[j]) --> array[k] = one[i]
//                  else --> array[k] = two[j]
//4. post process: add elements left to array

class MergeSortSolution2 {
    public int[] merge(int[] one, int[] two) {
        // Write your solution here
        //corner case
        if (one == null && two == null) {
            return null;
        }
        if (one == null) {
            return two;
        }
        if (two == null) {
            return one;
        }

        //if one != null && two != null
        int[] array = new int[one.length + two.length];
        int i = 0; //not one[0]
        int j = 0;
        int k = 0;
        while (i < one.length && j < two.length) {
            if (one[i] < two[j]) {
                array[k++] = one[i++];
            } else {
                array[k++] = two[j++];
            }
        }

        //post-process
        while (i < one.length) {
            array[k++] = one[i++];
        }
        while (j < two.length) {
            array[k++] = two[j++];
        }
        return array;
    }
}
