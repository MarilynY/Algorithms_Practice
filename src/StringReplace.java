public class StringReplace {
    public static void main(String[] args) {
        String input = "abcde";
        String source = "cd";
        String target1 = "X";
        String target2 = "XXX";
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
        char[] array = input.toCharArray();
        char[] sourceArray = source.toCharArray();
        char[] targetArray = target.toCharArray();
        //case 1: len(target) <= len(source)
        replaceShorter(array, sourceArray, targetArray);
        //case 2: len(target) > len(source)
        replaceLonger(array, sourceArray, targetArray);
        return new String(array);
    }
    private void replaceShorter(char[] array, char[] sourceArray, char[] targetArray) {

    }
    private void replaceLonger(char[] array, char[] sourceArray, char[] targetArray) {

    }
}