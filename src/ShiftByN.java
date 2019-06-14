public class ShiftByN {
    public static void main(String[] args) {
        String input = "abc";
        int n = 5;
        ShiftByNSol test = new ShiftByNSol();
        String res = test.rightShift(input, n);
        System.out.print(res);
    }
}
/*
Special case: when n > input.length()
a b c    n = 4
a moves 4 steps == a moves 1 step, same to bc
so n = n % array.length
Time: O(n)
Space: O(1)
 */
class ShiftByNSol {
    public String rightShift(String input, int n) {
        if (input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        n %= array.length;
        reverse(array, 0, array.length - 1);
        reverse (array, 0, n - 1);
        reverse(array, n, array.length - 1);
        return new String(array);
    }
    private void reverse(char[] array, int i, int j) {
        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }
}