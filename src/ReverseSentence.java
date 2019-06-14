public class ReverseSentence {
    public static void main(String[] args) {
        String input = "an apple";
        ReverseSentenceSol test = new ReverseSentenceSol();
        String res = test.reverseWords(input);
        System.out.print(res);
    }
}
//Time： O(n)
//Space: O(1)
class ReverseSentenceSol {
    public String reverseWords(String input) {
        // Write your solution here
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        //step 1: swap the whole sentence
        reverse(array, 0, array.length - 1);
        //step 2: swap single word
        int i = 0;
        int j = 0;
        while (j < array.length) {
            //首先必须是&& 不是||
            //必须先是j < array.length. 如果array[j] != ' '放在前面，就直接index out of bound了！
            while (j < array.length && array[j] != ' ') {
                j++;
            }
            reverse(array, i, j - 1);
            i = j + 1;
            j++;
        }
        return new String(array);
    }
    private void reverse(char[] array, int i, int j) {
        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            //把swap直接写在这里了， 但是别忘记i++， j++
            i++;
            j--;
        }
    }
}
