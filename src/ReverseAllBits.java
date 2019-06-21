public class ReverseAllBits {
    public static void main(String[] args) {
        int a = 0;
        ReverseAllBitsSol test = new ReverseAllBitsSol();
        int res = test.reverse(a);
        System.out.print(res);
    }
}


class ReverseAllBitsSol {
    public int reverse(int x) {
        int i = 0;
        int j = 31;
        while (i < j) {
            if (((x >>> j) & 1) != ((x >>> i) & 1)) {
                x = reverse(x, i, j);
            }
            i++;
            j--;
        }
        return x;
    }
    private int reverse(int x, int i, int j) {
        x ^= 1 << j;
        x ^= 1 << i;
        return x;
    }
}