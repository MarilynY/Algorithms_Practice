/*
index ： 7654 3210    set 4th to 1
bit：    0000 0101
       | 0001 0000
      -----------------
         0001 0101

Algorithms： num | (1 >> k)
theory: 1 | any bit == 1
        0 | any bit == any bit itself
*/

class BitSetterSol {
    public int setBit(int num, int k) {
        //那个数往左走就是<< 往右走就是>>
        return num | (1 << k);
    }
}

public class BitSetter {
    public static void main(String[] args) {
        int num = 1;
        int k = 1;
        BitSetterSol test = new BitSetterSol();
        int res = test.setBit(num, k);
        System.out.println(res);
    }
}