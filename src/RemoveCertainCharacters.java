import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*
Method 1: use hashSet
Time: O(n) or O(n^2)
Space: O(n)
 */
/*
class RemoveCertainCharactersSol {
    public String remove(String input, String t) {
        if (input.length() == 0 || t.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        Set<Character> set = new HashSet<>();
        //put all elements in t into set
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        int i = 0;
        int j = 0;
        while (j < array.length) {
            if (set.contains(array[j])) {
                j++;
            } else {
                array[i++] = array[j++];
            }
        }
        return new String(array, 0, i);
    }
}
*/

/*Method 1: In place
Time: O(length of input * length of t) worst case
Space: O(1)

 */
class RemoveCertainCharactersSol {
    public String remove(String input, String t) {
        // Write your solution here
        if (input.length() == 0 || t.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        char[] tArray = t.toCharArray();
        int i = 0;
        int j = 0;
        while (j < array.length) {
            int copyOfJ = j;
            for (char c : tArray) {
                if (array[j] == c) {
                    j++;
                    break;
                }
            }
            //只有当全部检查一遍之后，j没有++， 才证明这个字母不该删除
            if (copyOfJ == j) {
                array[i++] = array[j++];
            }
        }
       return new String (array, 0, i);
    }
}



public class RemoveCertainCharacters {
    public static void main(String[] args) {
        String A = "abcdebac";
        String B = "abc";
        RemoveCertainCharactersSol test = new RemoveCertainCharactersSol();
        String res = test.remove(A, B);
        System.out.print(res);
    }
}
/*
Test: a b a b a b b     gc
                  i
                    j
*/