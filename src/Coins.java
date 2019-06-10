import java.util.ArrayList;
import java.util.List;

public class Coins {
    public static void main(String[] args) {
        int[] coins = {25, 10, 5, 1};
        CoinsSolution test = new CoinsSolution();
        List<List<Integer>> res = test.combinations(25, coins);
        for (List<Integer> l : res) {
            System.out.println(l);
        }
    }

}

/*
Algorithm: DFS
Level of recursion tree: 4 levels. For each level, it store a kind of coin
number of states in each level: dynamic. remain / denomination of coin + 1
Demo: 99 cents

Level 0                       99 cents
                         /      |      |      \
Level 1  25cents      0*25      1*25  2*25    3*25         there are at most 3 25 cents in 99cents
          remain      99         74   49       24
Level 2  10cents  /||||||||\
               0*10 1*10...9*10
Level 3  5cents

Level 4  1cent

Base case: remain == 0 return
recursion:

*/
class CoinsSolution {
    public List<List<Integer>> combinations(int target, int[] coins) {
        //assumption: target > 0, have infinite coins
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        helper(target, 0, coins, result, sol);
        return result;
    }
    private void helper(int remain, int index, int[] coins, List<List<Integer>> result, List<Integer> sol) {
        //base case
        if (index == coins.length - 1) {
            sol.add(remain);
            result.add(sol);
            return;
        }
        for (int i = 0; i <= remain / coins[index]; i++) {
            sol.add(i);
            helper(remain - i * coins[index], index + 1, coins, result, sol);
            sol.remove(sol.size() - 1);
        }
    }
}