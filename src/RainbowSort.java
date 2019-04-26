import java.util.Arrays;

public class RainbowSort {
    public static void main(String[] args) {
        RainbowSortSolution test = new RainbowSortSolution();

        char[] array = {'a', 'c', 'a', 'b'};
        array = test.rainbowSort(array);
        System.out.println(Arrays.toString(array));
    }
}

/*
use 3 baffle to divide array into 4 areas
[0, i)  value a
[i, j)  value b
[j, k]  to be search
(k, n - 1) value c

1. initialize: int i = 0; int j = 0; int k = n-1
2. termination condition: j > k
3. for each step
       if array[j] == 'a' --> swap(i, j) i++ j++
       if array[j] == 'b' --> j++
       if array[j] == 'c' --> swap(j, k) k--

Time: O(n)
Space:O(1)

 */

class RainbowSortSolution {
    public char[] rainbowSort(char[] array) {
        int i = 0;
        int j = 0;
        int k = array.length - 1;

        //termination condition: j > k
        while (j <= k) {
            if (array[j] == 'a') {
                swap(array, i++, j++);

            } else if (array[j] == 'b') {
                j++;
            } else if (array[j] == 'c') {
                swap(array, j, k--);
            }
        }
        return array;
    }
    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
