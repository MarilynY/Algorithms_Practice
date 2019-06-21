import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        String input = "abcdefde";
        LongestSubstringSol test = new LongestSubstringSol();
        LongestSubstringSol2 test2 = new LongestSubstringSol2();
        int res = test.longest(input);
        int res2 = test2.longest(input);
        System.out.println(res);
        System.out.print(res2);
    }
}
/*
Algorithms: two pointers move towards same direction
use hashset to dedup
slow: left board of sliding window (slow is included)
fast: right board of sliding window (right is not included)
case 1： when a[f] is not in the hashtable
    add a[f] to hashSet f++
    globalMax = Math.max(globalMax, fast - slow)
case 2: when fast cannot move, move slow
    remove a[s] from hash set
    s--

a b c d e f g d e
s
f
*/
class LongestSubstringSol {
    public int longest(String input) {
        //for dedup
        Set<Character> distinct = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int longest = 0;
        while (fast < input.length()) {
            //case 1
            if (!distinct.contains(input.charAt(fast))) {
                distinct.add(input.charAt(fast++));
                //这里之所以是fast - slow 而不是fast - slow + 1是因为物理意义 fast is not included
                longest = Math.max(longest, fast - slow);
            } else { //case 2
                distinct.remove(input.charAt(slow++));
            }
        }
        return longest;
    }
}

/* 换一种物理意义去写
Algorithms: two pointers move towards same direction
use hashset to dedup
slow: left board of sliding window (slow is included)
fast: right board of sliding window (right is included)
case 1： when a[f] is not in the hashtable
    add a[f] to hashSet f++
    globalMax = Math.max(globalMax, fast - slow)
case 2: when fast cannot move, move slow
    remove a[s] from hash set
    s--

a b c d e f g d e
s
f
*/
//还是上一种物理意义比较简单明了
class LongestSubstringSol2 {
    public int longest(String input) {
        //for dedup
        Set<Character> distinct = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int longest = 1;
        distinct.add(input.charAt(fast));
        while (fast < input.length() - 1) {
            //case 1
            if (!distinct.contains(input.charAt(fast + 1))) {

                distinct.add(input.charAt(++fast));
                longest = Math.max(longest, fast - slow + 1);
            } else { //case 2
                distinct.remove(input.charAt(slow++));
            }
        }
        return longest;
    }
}