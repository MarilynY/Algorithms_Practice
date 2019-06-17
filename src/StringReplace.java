import java.util.ArrayList;
import java.util.List;

public class StringReplace {
    public static void main(String[] args) {
        String input = "aaa";
        String source = "aa";
        String target1 = " ";
        String target2 = "XXXX";
        StringReplaceSol test = new StringReplaceSol();
        String res1 = test.replace(input, source, target1);
        String res2 = test.replace(input, source, target2);
        System.out.println(res1);
        System.out.print(res2);
    }
}
/*
Case 1: len(target) <= len(source)len(target) <= len(source)
    Algotithm: two pointers
    i: the elements to the left hand side of i (not included i) have been processed and should be kept
    j: the element is being processed
    0 1 2 3 4
    a b X e e     source = cd    target = X
            i
              j
    initialize: int i = j = 0;
    For each step:
    see whether array[j] should be kept or replaced
        case 1: array[j] != source[0], kept
            array[i] = array[j], i++, j++
        case 2: array[j] == source[0] and array[j...j+source.length-1] == source[0, source.length-1], replace one by one
            for (int t = 0; t < target.length; t++)
                array[i] = target[t]
                i++
             when replacement is done,  j + source.length (all elements is source have been processed)
        termination condition: j = array.length

Case 2: len(target) > len(source)
    Algotithm: two pointers
    i: the elements to the right hand side of i (not included i) have been processed and should be kept
    j: the element is being processed
    Step1: interate the array and find how many times the source occurs int he array - counter = 1
    Step2: add [counter * (len(target) - len(source))] spaces after the array, then iterate the array from right
    a b X X X X e    source = cd target = XXXX counter = 1
      i
      j

    initialize: int i =
        case 1: array[j] != source[source.length - 1], kept
            array[i] = array[j], i--, j--
        case 2: array[j] = source[source.length - 1] and array[j ... j -source.length - 1] == source[source.length - 1, 0], replace
            j = j - len(source)
     temination condition: j > 0
 */

class StringReplaceSol {
    public String replace(String input, String source, String target) {
        char[] array = input.toCharArray();
        if (source.length() >= target.length()) {
            return replaceShorter(array, source, target);
        }
        return replaceLonger(array, source, target);
    }
    private String replaceShorter(char[] input, String s, String t) {
        int slow = 0;
        int fast = 0;
        while (fast < input.length) {
            //when we find a match of s on the substring from the fast pointer
            //we copy the t at slow pointer
            //最后一次可能copy的时候，就是在剩余长度是source的长度的时候
            //这里一定要提前结束，否则调用equalSubstring（）的时候会index out of bound
            if (fast <= input.length - s.length() && equalSubstring(input, fast, s)) {
                copySubstring(input, slow, t);
                slow += t.length();
                fast += s.length();
            } else {
                input[slow++] = input[fast++];
            }
        }
        return new String(input, 0, slow);
    }
    private String replaceLonger(char[] input, String s, String t) {
        List<Integer> matches = getAllMatches(input, s);
        int extendedSpace = matches.size() * (t.length() - s.length());
        char[] result = new char[input.length + extendedSpace];
        //the rightmost matching end position's index
        int lastIndex = matches.size() - 1;
        int slow = result.length - 1;
        int fast = input.length - 1;
        while (fast >= 0) {
            if (lastIndex >= 0 && fast == matches.get(lastIndex)) {
                copySubstring(result, slow - t.length() + 1, t);
                slow -= t.length();
                fast -= s.length();
                lastIndex--;
            } else {
                result[slow--] = input[fast--];
            }
        }
        return new String(result);
    }
    private boolean equalSubstring(char[] input, int fromIndex, String s) {
        //pass by value
        //fromIndex is just copy of fast, so fast will not be changed
        for (int i = 0; i < s.length(); i++) {
            if (input[fromIndex + i] != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    private void copySubstring(char[] result, int fromIndex, String t) {
        for (int i = 0; i < t.length(); i++) {
            result[fromIndex + i] = t.charAt(i);
        }
    }
    private List<Integer> getAllMatches(char[] input, String s) {
        List<Integer> matches = new ArrayList<>();
        int i = 0;
        while (i <= input.length - s.length()) {
            if (equalSubstring(input, i, s)) {
                //we record the match substring's end index instead of the start index
                //for later convience
                matches.add(i + s.length() - 1);
                i += s.length();
            } else {
                i++;
            }
        }
        return matches;
    }
}






/*我的写法，laicode没过
class StringReplaceSol {
    public String replace(String input, String source, String target) {
        //S T are not null. S is not empty
        //corner case
        if (input == null || input.length() == 0) {
            return input;
        }
        if (target.length() <= source.length()) {
            return replaceShorter(input, source, target);
        } else {
            return replaceLonger(input, source, target);
        }

    }
    private String replaceShorter(String input, String source, String target) {
        char[] array = input.toCharArray();
        char[] sourceArray = source.toCharArray();
        char[] targetArray = target.toCharArray();
        int i = 0;
        int j = 0;
        while (j < array.length) {
            int temp = j;
            if (array[j] != sourceArray[0]) {
                 array[i++] = array[j++];
            } else {
                //check if whole pattern match
                for (int k = 0; k < sourceArray.length; k++) {
                    if (array[temp] != sourceArray[k]) {
                        break;
                    }
                    temp++;
                }
                //replace if the whole pattern match
                if (temp - j == sourceArray.length) {
                    //source found, start to replace
                    for (int k = 0; k < targetArray.length; k++) {
                        array[i] = targetArray[k];
                        i++;
                    }
                    j += sourceArray.length;
                }
            }
        }
        return new String(array, 0, i);
    }
    private String replaceLonger(String input, String source, String target) {
        char[] array = input.toCharArray();
        char[] sourceArray = source.toCharArray();
        char[] targetArray = target.toCharArray();
        //calculate how many source patterns in the array
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == sourceArray[0]) {
                int temp = i;
                for (int j = 0; j < sourceArray.length; j++) {
                    //sourceArray[j] 写成了array[j]
                    if (array[temp] == sourceArray[j]) {
                        temp++;
                    } else {
                        break;
                    }
                }

                if (temp - i == sourceArray.length) {
                    counter++;
                }
            }
        }
        //enlarge array
        char[] newArray = new char[array.length + counter];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        //iterate new array from right to left
        */
/*
        * studentden _ _     source = den   target = XXXX
        *              i
        *          j
        * *//*

        int i = newArray.length - 1;
        for (int j = newArray.length - 1 - counter; j >= 0; j--) {
            if (newArray[j] != sourceArray[sourceArray.length - 1]) {
                newArray[i--] = newArray[j];
            } else {
                int temp = j;
                for (int k = sourceArray.length - 1; k >= 0; k--) {
                    if (newArray[temp] == sourceArray[k]) {
                        temp--;
                    } else {
                        break;
                    }
                }
                if (j - temp == sourceArray.length) {
                    for (int t = targetArray.length - 1; t >= 0; t--) {
                        newArray[i--] = targetArray[t];
                    }
                    //用for loop最讨厌的就是容易忘记上面还有个j--，所以这里要加+
                    //而且从后往前iterate 的 forloop别忘记终止条件是>=0
                    j = j - sourceArray.length + 1;
                }
            }
        }
        return new String(newArray);
    }
}*/
