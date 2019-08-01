public class BitTester {
    public static void main(String[] args) {
        int num = 3;
        int k = 0;
        CheckIfKthIs1Sol test = new CheckIfKthIs1Sol();
        boolean res = test.checkIf1(num, k);
        System.out.print(res);

    }
}
/*
* Bit tester
* if (num >> k) & 1   ==  1  --> the kth bit is 1
* else --> the kth bit is 0
* Theory:
* 1 only & 1 == 1
* o & any bit == 0
* */
class CheckIfKthIs1Sol {
    public boolean checkIf1(int num, int k) {
        //这里一定要多加一层括号，因为== 比& 优先级高
        if ((1 & (num >> k)) == 1) {
            return true;
        } else {
            return false;
        }
    }
}