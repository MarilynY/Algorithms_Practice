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
        //StringBuilder sb = new StringBuilder();
        char[] array = set.toCharArray();
        helper(array, 0, result);
        return result;
    }
    private void helper(char[] array, int index, List<String> result) {
        //base case
        if (index == array.length) {
            result.add(new String(array));
        }
        //index 相当于一个挡板，是一个位置，我把这个挡板后面的所有数都放到挡板的位置来看看一看
        for (int i = index; i < array.length; i++) {
            swap(array, index, i);
            helper(array, index + 1, result);
            swap(array, index, i);
        }
    }
    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
