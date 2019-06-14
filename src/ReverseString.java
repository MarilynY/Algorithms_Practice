public class ReverseString {
    public static void main(String[] args) {
        String input = "apple";
        ReverseStringSolution test = new ReverseStringSolution();
        String res = test.reverse(input);
        System.out.print(res);
    }
}

//Iteratively
/*
class ReverseStringSolution {
    public String reverse(String input) {
        //input is not null
        if (input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int i = 0;
        int j = input.length() - 1;
        while (i < j) {
            swap(array, i++, j--);
        }
        return new String(array);
    }
    private void swap(char[] array, int i, int j) {
       char temp = array[i];
       array[i] = array[j];
       array[j] = temp;
    }
}

//用 string builder去swap
class ReverseStringSolution {
    public String reverse(String input) {
        //input is not null
        if (input.length() <= 1) {
            return input;
        }
        StringBuilder sb = new StringBuilder(input);
        int i = 0;
        int j = input.length() - 1;
        while (i < j) {
            swap(sb, i++, j--);
        }
        return new String(sb);
    }
    //如果一定要用stringbuilder去swap， 必须这么写！！！
    private void swap(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }
}
*/


/*Recursively preorder
assume I have reverse the elements in between, now I just need to reverse two letters on the sides
a l p p e
  -----
i       j
base case : i >= j return  (when 1 element or 0 element between (i,j))
subproblem: String str = reverse(array, i + 1, j - 1);
recursion rule: swap(array, i, j);
*/

class ReverseStringSolution {
    public String reverse(String input) {
        if (input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        reverse(array, 0, array.length - 1);
        return new String(array);
    }
    private void reverse(char[] array, int leftBound, int rightBound) {
        if (leftBound >= rightBound) {
            return;
        }
        //subproblem
        reverse(array, leftBound + 1, rightBound - 1);
        //current layer logic
        swap(array, leftBound, rightBound);
    }
    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}



