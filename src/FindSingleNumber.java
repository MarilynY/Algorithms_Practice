public class FindSingleNumber {
    public static void main(String[] args) {
        int[] A = {-1};
        int res = findSingleNumber(A);
        System.out.print(res);
    }
    public static int findSingleNumber(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] != A[i + 1]) {
                return A[i];
            }
            i++;
        }
        return A[A.length - 1];
    }
}
