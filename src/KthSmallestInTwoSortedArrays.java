public class KthSmallestInTwoSortedArrays {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {5, 6, 7, 8};
        KthSmallestInTwoSortedArraysSolution test = new KthSmallestInTwoSortedArraysSolution();
        int res = test.kth(a, b, 7);
        System.out.print(res);
    }
}

class KthSmallestInTwoSortedArraysSolution {
    public int kth(int[] a, int[] b, int k) {
        return kth(a, 0, b, 0, k);
    }
    private int kth(int[] a, int aleft, int[] b, int bleft, int k) {
        System.out.println("k:" + k); //7 4 2 1
        //base case
        if (aleft >= a.length) { //极端想像成 a是空， 那么第k小，就是b array的第k-1个元素
            System.out.println("aleft:" + aleft);
            System.out.println("bleft:" + bleft);
            System.out.println("k:" + k);
            return b[bleft + k - 1]; //此时的k已经不是嘴一开始的k了
        }
        if (bleft >= b.length) {//同理
            return a[aleft + k - 1];
        }
        if (k == 1) {
            return Math.min(a[aleft], b[bleft]);
        }
        int amid = aleft + k/2 - 1;
        int bmid = bleft + k/2 - 1;
        int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
        int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
        if (aval <= bval) {
            return kth(a, amid + 1, b, bleft, k - k/2);
        } else {
            //System.out.println("k:" + k);
            return kth(a, aleft, b, bmid + 1, k - k/2);
        }
    }
}

/*
round 1: k = 7, aleft = 0, bleft = 0
round 2: k = 4, amid = 2, aleft = amid + 1 = 3, bleft = 0
round 3: k = 2, amid = 3, aleft = 3, bleft = 2
round 4：k = 1, aleft = 4, 出界 -》 base case

在这个工程中，搜索范围k是在不断变化的
*/