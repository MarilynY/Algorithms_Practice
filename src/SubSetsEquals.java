import java.util.ArrayList;
import java.util.List;

public class SubSetsEquals {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2};
        SubSetsEqualsSol test = new SubSetsEqualsSol();
        List<List<Integer>> res = test.subsetsEquals(array);
        for (List<Integer> list : res) {
            System.out.print(list.toString());
        }
    }
}

class SubSetsEqualsSol {
    public List<List<Integer>> subsetsEquals(int[] array) {
        //assume array is not null and array.length >= 2
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        List<Integer> solution = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(array, solution, result, 0, sum);
        return result;
    }
    private void helper(int[] array, List<Integer> solution, List<List<Integer>> result, int level, int sum) {
        //base case
        if (level == array.length) {
            int currSum = 0;
            for (int i : solution) {
                currSum += i;
            }
            int restSum = sum - currSum;
            if (restSum == currSum) {
                result.add(new ArrayList(solution));
            }
            return;
        }
        //case 1:
        solution.add(array[level]);
        helper(array, solution, result, level + 1, sum);
        solution.remove(solution.size() - 1);
        //case 2:
        helper(array, solution, result, level + 1, sum);
    }
}