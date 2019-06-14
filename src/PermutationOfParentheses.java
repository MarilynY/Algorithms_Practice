import java.util.ArrayList;
import java.util.List;

public class PermutationOfParentheses {
    public static void main(String[] args) {
        int n = 3;
        int i = 1;
        PermutationOfParenthesesSol test = new PermutationOfParenthesesSol();
        List<String> res = test.validParentheses(n);
        for (String s : res) {
            System.out.println("The " + i + "th result: " + s);
            i++;
        }
    }
}
/*
 Level of recursion tree: 2n, for each level, it hold one position. either ( or ) will be added .
 number of states in each level: 2 states: add ( or add )
 Demo: n = 2
 L0           {}
 L1       {(}     {)}
 L2    {((}  {()}  {)(}{))}
 L3      {}  {}{}{}{}{}{}
 L4
 Time: O(2^2n)
 Space: O(n)
 */
class PermutationOfParenthesesSol {
    public List<String> validParentheses(int n) {
        //assumption: n > 0
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(n, 0, 0, result, sb);
        return result;
    }
    private void helper(int n, int leftNum, int rightNum, List<String> result, StringBuilder sb) {
        //base case
        if (leftNum == n && rightNum == n) {
            result.add(sb.toString());
            return;
        }
        //add left
        if (leftNum < n) {
            sb.append('(');
            helper(n, leftNum + 1, rightNum, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        //add right
        if (rightNum < leftNum) {
            sb.append(')');
            helper(n, leftNum, rightNum + 1, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}