public class StringReplace {
    public static void main(String[] args) {
        String input = "studentdent";
        String source = "den";
        String target1 = "X";
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
        //S T are not null. S is not empty
        //corner case
        if (input == null || input.length() == 0 || target.length() == 0) {
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
                    if (array[temp] == array[j]) {
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
        //iterate new array from right to left
        /*
        * studentden _ _     source = den   target = XXXX
        *              i
        *          j
        * */
        int i = newArray.length - 1;
        for (int j = array.length - 1; j > 0; j--) {
            if (newArray[j] != sourceArray[sourceArray.length - 1]) {
                newArray[i--] = newArray[j--];
            } else {
                int temp = j;
                for (int k = sourceArray.length - 1; k > 0; k--) {
                    if (newArray[temp] == sourceArray[k]) {
                        temp--;
                    } else {
                        break;
                    }
                }
                if (j - temp == sourceArray.length) {
                    for (int t = targetArray.length - 1; t > 0; t--) {
                        newArray[i--] = targetArray[t];
                    }
                    j = j - sourceArray.length;
                }
            }
        }
        return new String(newArray);
    }
}