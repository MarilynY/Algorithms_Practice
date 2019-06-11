import java.util.HashSet;
import java.util.Set;

public class MissingNumberI {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5};
        MissingNumberISolution test = new MissingNumberISolution();
        int res = test.missing(array);
        System.out.println(res);
    }
}
//Method 4： bit operation (xor)
//why use it?
//a ^ b = b ^ a
//a ^ (b ^ c) = (a ^ b) ^ c
//a ^ 0 = a
//a ^ a = 0
//1 ^ 1 = 0  0 ^ 0 = 0 1 ^ 0 = 1
//(1 ^ 2 ^ ...N) ^ (a[0] ^ a[1] ^ ... a[N-1])
// = missing number
//Time: O(n)
//Space: O(1)
class MissingNumberISolution {
    public int missing(int[] array) {
        if (array.length == 0) {
            return 1;
        }
        int n = array.length + 1;
        int xor = 0;
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        for (int num : array) {
            xor ^= num;
        }
        return xor;
    }
}

//Method 3: use sum(be careful int overflow use long)
//assume N = 3   array.length == N-1 = 2
//(1 + 2 + 3) - (array[0] + array[1]) == missing number
//Time: O(n)
//Space: O(1)
/*
class MissingNumberISolution {
    public int missing(int[] array) {
        if (array.length == 0) {
            return 1;
        }
        int n = array.length + 1;
        //等差数列前n项和
        long targetSum = (n + 0L) * (1 + n) / 2;
        long actualSum = 0L;
        for (int t : array) {
            actualSum += t;
        }
        return (int) (targetSum - actualSum);
    }
}
*/


//Method 2: boolean array
//boolean[] occurred [n+1]
//occurred[i] represents whether i is in the array
//if occurred[i] == false, return i
//Time: O(n)
//Space: O(n)
/*
class MissingNumberISolution {
    public int missing(int[] array) {
        if (array.length == 0) {
            return 1;
        }
        int n = array.length;
        boolean[] occurred = new boolean[n + 1];
        //iterate original array
        for (int i = 0; i < n; i++) {
            int t = array[i];
            if (t < occurred.length) {
                occurred[t] = true;
            }
        }
        int j = 1;
        for (;j < occurred.length; j++) {
            if (occurred[j] == false) {
                break;
            }
        }
        return j;
    }
}
*/


//Method 1: HashSet
//Time: O(n) O(n^2) worst
//Space: O(n) O(n^2) worst
/*
class MissingNumberISolution {
    public int missing(int[] array) {
        //assumption: array is not null N >= 1
        if (array.length == 0) {
            return 1;
        }
        Set<Integer> hashSet = new HashSet<>();
        //step 1:
        for (int i = 0; i < array.length; i++) {
            hashSet.add(array[i]);
        }
        //step2
        int i;
        for (i = 1; i <= array.length; i++) {
            if (!hashSet.contains(i)) {
                break;
            }
        }
        return i;
    }
}
*/
