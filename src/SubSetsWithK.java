import java.util.ArrayList;
import java.util.List;

public class SubSetsWithK {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        SubSetsWithKSolution test = new SubSetsWithKSolution();
        List<List<Integer>> res = test.subsetsWithK(array, 2);
        for (List<Integer> list : res) {
            System.out.print(list);
        }
    }
}


class SubSetsWithKSolution {
    public List<List<Integer>> subsetsWithK(int[] array, int k) {
        //assume array is not null, length >= 2
        List<Integer> solution = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(array, result, solution, 0, k);
        return result;
    }
    private void helper(int[] array, List<List<Integer>> result, List<Integer> solution, int level, int k) {
        //base case
        if (level == array.length || solution.size() == k) {
            if (solution.size() == k) {
                result.add(new ArrayList(solution));
            }
            return;
        }
        //case 1: add letter in current layer
        solution.add(array[level]);
        helper(array, result, solution, level + 1, k);
        solution.remove(solution.size() - 1);
        //case 2: do not add letter in current layer
        helper(array, result, solution, level + 1, k);
    }
}