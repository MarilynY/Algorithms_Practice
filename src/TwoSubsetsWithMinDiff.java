import java.util.ArrayList;
import java.util.List;

public class TwoSubsetsWithMinDiff {
}

/*
DFS
Step 1：calculate the sum of whole array
Step 2: calculate the sum of all subsets whose length is array.length / 2
step 2: use global min to record the minimum difference between two subsets
*/
class TwoSubsetsWithMinDiffSolution {
    public int minDifference(int[] array) {
        //assume array is not null, length >= 2
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        List<Integer> currRes = new ArrayList<>();
        int[] globalMinDiff = new int[]{Integer.MAX_VALUE};
        helper(array, globalMinDiff, currRes, 0, sum);
        return globalMinDiff[0];
    }
    private void helper(int[] array, int[] globalMinDiff, List<Integer> currRes, int level, int sum) {
        //base case
        if (level == array.length) {
            if (currRes.size() == array.length / 2) {
                int currSum = 0;
                for (Integer i : currRes) {
                    currSum += i;
                }
                //diff = restSum - currSum = sum - currSum - currSum = sum - 2*currSum
                globalMinDiff[0] = Math.min(globalMinDiff[0], Math.abs(sum - 2 * currSum));
            }
            return;
        }
        //case 1: add letter in current layer
        currRes.add(array[level]);
        helper(array, globalMinDiff, currRes, level + 1, sum);
        currRes.remove(currRes.size() - 1);
        //case 2: do not add letter in current layer
        helper(array, globalMinDiff, currRes, level + 1, sum);
    }
}