import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SubsetsII {
    public static void main(String[] args) {
        String set = "bab";
        SubsetsIISol test = new SubsetsIISol();
        List<String> res = test.subSets(set);
        System.out.print(res);
    }
}
class SubsetsIISol {
    public List<String> subSets(String set) {
        List<String> result = new ArrayList<>();
        //return []
        if (set == null) {
            return result;
        }
        //return [""]
        if (set.length() == 0) {
            result.add("");
            return result;
        }

        char[] array = set.toCharArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        helper(array, sb, result, 0);
        return result;
    }
    private void helper(char[] array, StringBuilder sb, List<String> result, int level) {
        //base case
        if (level == array.length) {
            result.add(sb.toString());
            return;
        }
        //case 1: add array[level]
        sb.append(array[level]);
        helper(array, sb, result, level + 1);
        sb.deleteCharAt(sb.length() - 1);

        //dedup
        while (level < array.length - 1 && array[level] == array[level + 1]) {
            level++;
        }
        //case 2: do not add array[level]
        helper(array, sb, result, level + 1);
    }
}






/*
public class SubsetsII {
    public static void main(String[] args) {
        int[] array = {1, 2, 2};
        SubsetsIISol test = new SubsetsIISol();
        test.subsetsII(array);
    }
}

class SubsetsIISol {
    public void subsetsII(int[] array) {
        List<Integer> solution = new ArrayList<>();
        helper(array, solution, 0);
    }
    private void helper(int[] array, List<Integer> solution, int level) {
        if (level == array.length) {
            System.out.print(solution.toString());
            return;
        }
        //case 1: add array[level]
        solution.add(array[level]);
        helper(array, solution, level + 1);
        solution.remove(solution.size() - 1);

        //dedup
        //avoid index out of bound
        while (level < array.length - 1 && array[level] == array[level + 1]) {
            //其实这个level++ 意思就是跳过了了array[level]这个元素，直接去到，下一个元素了
            level++;
        }

        //case 2: do not add array[level]
        helper(array, solution, level + 1);
    }
}
*/
