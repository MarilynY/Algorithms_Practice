import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 1, 3, 4, 5, 1, 3, 4, 5, 6, 7, 3, 5, 7, 3, 5, 9, 0, 2, 3, 8, 9};
        int[] result = CountSortSolution.countSort(array);
        System.out.print(Arrays.toString(result));
    }
}

class CountSortSolution {
    public static int[] countSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        //group same elements with a new temp array
        //assume the range of numbers are 0-9
        int[] temp = new int[10];

        //iterate temp array and then get result in a new result array
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            temp[array[i]]++;
        }
        int i = 0;// if i in the for loop, it will become 0 after every iteration
        //j is the index of temp array
        for (int j = 0; j < temp.length; j++) {
            while (temp[j] != 0) {
                result[i] = j;
                i++;
                temp[j]--;
            }
        }
        return result;
    }
}