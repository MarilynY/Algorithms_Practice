import java.util.ArrayList;
import java.util.List;

public class AllPermutationI {
    public static void main(String[] args) {
        String str = "abc";
        AllPermutationISol test = new AllPermutationISol();
        List<String> res = test.permutations(str);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
/*
1. 3 levels in recursion tree, each level considers a position
2. states in each level depends
position 0                  root (abc)
      i               /         |           \
position 1           a        b            c
                    /  \    /  \         /   \
position 2          b   c   a  c         a   b
                    |   |   |  |         |    |
position 3          c    b  c  a         b    a

Time: O(N!)  因为第一层是3个叉，第二层2个叉。。。3 + 2 + 1 = n!   O(叉数^level)
Space: O(N)
*/
class AllPermutationISol {
    public List<String> permutations(String set) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] array = set.toCharArray();
        helper(array, 0, result, sb);
        return result;
    }
    private void helper(char[] array, int index, List<String> result, StringBuilder sb) {
        //base case
        if (index == array.length) {
            result.add(sb.toString());
        }
        for (int i = index; i < array.length; i++) {
            sb.append(array[i]);
            helper(array, index + 1, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
