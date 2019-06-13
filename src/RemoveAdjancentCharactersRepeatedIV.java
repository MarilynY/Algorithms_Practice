import java.util.Deque;
import java.util.LinkedList;

public class RemoveAdjancentCharactersRepeatedIV {
    public static void main(String[] args) {
        String input = "aabbza";
        RemoveAdjancentCharactersRepeatedIVSol test = new RemoveAdjancentCharactersRepeatedIVSol();
        String res = test.deDup(input);
        System.out.print(res);
    }
}
/*
Method 1： use two pointers to mimic a stack on the original char array
i: (0, i) are the elements should be kept(i is not included)      i-1 is the top of the stack
j: linear search index

Demo: a a b b c a
        i
        j
initialize: int i = 1, j = 1
For each step:
see whether array[j] should be kept
    case 1: i == 0 (stack is empty) || i > 0 && array[j] != array[i-1],
            array[i++] = array[j++];
    case 2: i > 0 && array[j] == array[i-1],
            keep j++ until j = array.length || array[j] != array[i-1], then i--
Termination condition: j = array.length
Time: o(n)
Space: O(1)
 */
    
class RemoveAdjancentCharactersRepeatedIVSol {
    public String deDup(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int i = 1;
        int j = 1;
        //特别小心array index out of bound： i must > 0, j must < array.length
        while (j < array.length) {
            if (i == 0 || i > 0 && array[j] != array[i - 1]) {
                array[i++] = array[j++];
            } else if (i > 0 && array[j] == array[i - 1]) {
                //j < array.length 勿忘
                while (j < array.length && array[i - 1] == array[j]) {
                    j++;
                }
                i--;
            }
        }
        return new String(array, 0, i);
    }
}








/*
Method 2: use stack
i: the elements to the left-hand side if i (i is not included) should be kept
j: linear scan pointer

Demo: a a b b c a
      i
          j

stack:

initialize: int j = 0
For each step:
    case 1: stack.isEmpty() -> stack.push(array[j]), j++
    case 2: !stack.isEmpty() && array[j] == stack.peek() -> keep doing j++ until array[j] != stack.peek(), then stack.pop();
    case 3: !stack.isEmpty() && array[j] != stack.peek() -> stack.push(array[j]), j++
Termination condition : j = array.length
cannot pass test case "aabbza", but laicode pass

 */
/*
class RemoveAdjancentCharactersRepeatedIVSol {
    public String deDup(String input) {
        //corner case
        if (input == null || input.length() <= 1) {
            return input;
        }
        Deque<Character> stack = new LinkedList<>();
        char[] array = input.toCharArray();
        //stack must initialized

        int j = 0;
        while (j < array.length) {
            if (stack.isEmpty() || array[j] != stack.peek()) {
                stack.push(array[j]);
                j++;
            } else if (!stack.isEmpty() && array[j] == stack.peek()) {
                while (j < array.length && stack.peek() == array[j]) {
                    j++;
                }
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}

 */































