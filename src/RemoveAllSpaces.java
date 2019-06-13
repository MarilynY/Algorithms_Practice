public class RemoveAllSpaces {
    public static void main(String[] args) {
        String input = "  ";
        RemoveAllSpacesSol test = new RemoveAllSpacesSol();
        String res = test.removeSpaces(input);
        System.out.print(res);
    }
}
/*
Assumption: input is not null
Algorithms: two pointers
i: elements to the left-hand side of i (i is not included) should be kept
j: the element is processing

Demo:    s f v _de_ _ de_ _
                    i
                            j
Initialize: int i = 0; int j = 0
For each step:
see whether input.charAt(j) should be kept
    case 1: input.charAt(j) == ' ' && i == 0, ignore j++      (remove leading spaces)
    case 2: input.charAt(j) != ' ', kept, array[i] = array[j], i++, j++               (remove spaces in middle)
    case 3: input.charAt(j) == ' ', input.charAt(i-1) != ' ', kept, array[i] = array[j], i++,j++
    case 4: input.charAt(j) == ' ', input.charAt(i-1) == ' ', ignore j++



    post process:
        if input.charAt(i-1) == ' ', i--         (remove the tailing spaces)
Termination condition: j = input.length()
Time： O(n)
Space: O(1) if charArray and output does not take spaces
 */
class RemoveAllSpacesSol {
    public String removeSpaces(String input) {
        if (input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        int i = 0;
        int j = 0;
        while (j < array.length) {
            if (array[j] != ' ') {
                array[i++] = array[j++];
            } else if (array[j] == ' ' && (i == 0 || array[i - 1] == ' ')) {
                j++;
            } else {
                array[i++] = array[j++];
            }
        }
        //post process
        //注意： input可能全是space，一定要加i>=1的判断
        if (i >= 1 && array[i - 1] == ' ') {
            i--;
        }
        return new String(array, 0, i);
    }
}

