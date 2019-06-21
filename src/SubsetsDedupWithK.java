import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsDedupWithK {
    public static void main(String[] args) {
        char[] array = {'b', 'a', 'b'};
        SubsetsDedupWithKSol test = new SubsetsDedupWithKSol();
        List<String> res = test.subSetsKDedup(array, 2);
        System.out.print(res);

    }
}
class SubsetsDedupWithKSol {
    public List<String> subSetsKDedup(char[] array, int k) {
        List<String> result = new ArrayList<>();
        if (array == null) {
            return result;
        }
        if (array.length == 0) {
            result.add("");
            return result;
        }
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        helper(array, sb, result, 0, k);
        return result;
    }
    private void helper(char[] array, StringBuilder sb, List<String> result, int level, int k) {
        if (level == array.length) {
            if (sb.length() == k) {
                result.add(sb.toString());
            }
            return;
        }
        //case 1: add array[level]
        helper(array, sb.append(array[level]), result, level + 1, k);
        sb.deleteCharAt(sb.length() - 1);

        //dedup
        while (level < array.length - 1 && array[level] == array[level + 1]) {
            level++;
        }
        //case 2: do not add array[level]
        helper(array, sb, result, level + 1, k);
    }
}