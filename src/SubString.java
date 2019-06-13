public class SubString {
    public static void main(String[] args) {
        String small = "bbab";
        String large = "abbaabbab";
        SubStringSol test = new SubStringSol();
        int res = test.strstr(large, small);
        System.out.print(res);
    }
}
/*
Demo: A : a b c f d            B: cfd
            i->                   j
Initialize: int i = j = 0
For each step:
    case 1: if array[i] == array[j] -> for loop the string B to see if letters match
        case 1.1: if all letters match -> return index i before looping
        case 1.2: if no, keep iterating the letters in array A
Termination condition: when i > A.length - B.length

Time: O(n^2)
 */


class SubStringSol {
    public int strstr(String large, String small) {
        // small and large are not null
        if (small.length() == 0) {
            return 0;
        }
        if (small.length() > large.length()) {
            return -1;
        }
        char[] s = small.toCharArray();
        char[] l = large.toCharArray();
        //must be <= don't forget ==
        for (int i = 0; i <= l.length - s.length; i++) {
            int temp = i;
            int j = 0;
            if (l[i] == s[j]) {
                while (j < s.length) {
                    if (l[temp] == s[j]) {
                        temp++;
                        j++;
                    } else {
                        break;
                    }
                }
                if (temp - i  == s.length) {
                    return i;
                }
            }
        }
        //small is not the substring of large
        return -1;
    }
}
/*
test case: abcde   n = 5    cd  n = 2
             i                j
               t
 */
