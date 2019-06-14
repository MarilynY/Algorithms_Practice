import java.util.ArrayList;
import java.util.List;

public class FindAllSubSets {
    public static void main(String[] args) {
        String set = "abc";
        FindAllSubSetsSolution test = new FindAllSubSetsSolution();
        List<String> result = test.subSets(set);
        for (String s : result) {
            System.out.println(s);
        }
    }
}

class FindAllSubSetsSolution {
    public List<String> subSets(String set) {
        List<String> res = new ArrayList<>();
        if (set == null) { //string uses length
            return res;
        }
        StringBuilder  solutionPrefix = new StringBuilder();
        //string to charArray
        char[] input = set.toCharArray();
        subSets(input, 0, res, solutionPrefix);
        return res;

    }
    private void subSets(char[] input, int index, List<String> res, StringBuilder solutionPrefix) {
        //base case
        if (index == input.length) {
            res.add(solutionPrefix.toString());
            return;
        }
        //does not select letter
        subSets(input, index + 1, res, solutionPrefix);
        //select letter
        subSets(input, index + 1, res, solutionPrefix.append(input[index]));
        //backtrack
        solutionPrefix.deleteCharAt(solutionPrefix.length() - 1);
    }
}