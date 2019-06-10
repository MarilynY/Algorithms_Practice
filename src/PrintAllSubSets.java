import java.util.ArrayList;
import java.util.List;

public class PrintAllSubSets {
    public static void main(String[] args) {
        String str = "abc";
        PrintAllSubSetsSol test = new PrintAllSubSetsSol();
        List<String> result = test.subSets(str);
        int i = 0;
        for (String s : result) {
            System.out.println("The " + i+"th element:" + s);
            i++;
        }
    }
}

class PrintAllSubSetsSol {
    public List<String> subSets(String str) {
        //corner case
        if (str == null) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        //convert string to char array
        char[] array = str.toCharArray();
        helper(array, 0, result, sb);
        return result;
    }
    private void helper(char[] array, int index, List<String> result, StringBuilder sb) {
        //base case
        if (index == array.length) {
            result.add(sb.toString());
            return;
        }
        //case 1: select the letter in this level
        sb.append(array[index]);
        helper(array, index + 1, result, sb);
        sb.deleteCharAt(sb.length() - 1);
        //case 2: does not select the letter in this level
        helper(array, index + 1, result, sb);
    }
}