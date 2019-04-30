public class FibonacciSequence {
    public static void main(String[] args) {

        int x = 6;
        int result = FibonacciSequenceSolution.fibonacciSequence(x);
        System.out.print(result);
    }
}

class FibonacciSequenceSolution {
    public static int fibonacciSequence (int n) {
        //base case
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
//Time = O(n)
//Space = O(1)