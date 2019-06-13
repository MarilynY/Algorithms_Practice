import java.util.*;

public class CommonsNumbersInTwoSortedArray {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        List<Integer> B = new ArrayList<>();
        B.add(1);
        B.add(3);
        B.add(3);
        CommonsNumbersInTwoSortedArraySol test = new CommonsNumbersInTwoSortedArraySol();
        List<Integer> res = test.common(A, B);

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));

        }
    }
}


/*
Method 2： Hash table
Clarify:
    sorted in ascending order
    has duplicted numbers return all of them
    How large A and B? can be store in memory
Data Structure : Hash set
Step 1: put all elements in List A to hashmap -- O(A.size()) on average
Step 2: iterate List B, to see if hashmap contains the elements in B. if yes, add it to result -- O(B.size()) on average
*/
//Implmentation 1
/*
class CommonsNumbersInTwoSortedArraySol {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<>();
        //put elements in list A to hashMapA
        Map<Integer, Integer> hashMapA = new HashMap<>();
        for (Integer num : A) {
            hashMapA.put(num, hashMapA.getOrDefault(num, 0) + 1);

            //RIGHT!!
            //Integer count = hashMapA.get(num);
            //if (count != null) {
            //   hashMapA.put(num, count + 1);
            //} else {
            //    hashMapA.put(num, 1);
            //}

            //RIGHT!!
            //int count = hashMapA.containsKey(num) ? hashMapA.get(num) : 0;
            //hashMapA.put(num, count + 1);

            //wrong!!!!
            //int count = hashMapA.getOrDefault(hashMapA.get(num), 0);
            //hashMapA.put(num, count + 1);
        }
        //for debug
        //for (Map.Entry<Integer, Integer> entry : hashMapA.entrySet()) {
        //    System.out.print(entry.getKey() + "," + entry.getValue() + " ");
        //}

        //put elements in List B to hashMapBa
        Map<Integer, Integer> hashMapB = new HashMap<>();
        for (Integer num : B) {
            hashMapB.put(num, hashMapB.getOrDefault(num, 0) + 1);
        }
        //compare two hashMaps find entry in hashMapA in hashMapB
        for (Map.Entry<Integer, Integer> entry : hashMapA.entrySet()) {
            if (hashMapB.containsKey(entry.getKey())) {
                int appear = Math.min(entry.getValue(), hashMapB.get(entry.getKey()));
                for (int i = 0; i < appear; i++) {
                    result.add(entry.getKey());
                }
            }
        }
        return result;
    }
}
*/
//Implmentation 2
/*
class CommonsNumbersInTwoSortedArraySol {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<>();
        //corner case
        if (A.size() == 0 || B.size() == 0) {
            return result;
        }
        //put all elements in ListA to a hashtable
        Map<Integer, Integer> hashMapA = new HashMap<>();
        for (Integer num : A) {
            hashMapA.put(num, hashMapA.getOrDefault(num, 0) + 1);
        }
        //iterate List B to see if anyone in the hashMapA, if yes, add it to result
        for (Integer num : B) {
            if (hashMapA.containsKey(num)) {
                int count = hashMapA.get(num);
                if (count > 0) {
                    result.add(num);
                    hashMapA.put(num, count - 1);
                }
            }
        }
        return result;
    }
}
*/


/*
Method 1: two pointers(can be used for having duplicated elements or not)
assume: the lengths of two Lists are rough same.
Algorithm: two pointers
List A 1 2 3 3
       i
List B 1 1 3 4
       j
For each step:
    case 1: A.get(i) < B.get(j) -> i++
    case 2: A.get(i) == B.get(j) -> res.add(A.get(i)), i++, j++
    case 3: A.get(i) > B.get(j) -> j++
Termination condition: when i > A.size() || j > B.size() stop
Time: O(m+n)
Space: O(1)
 */
/*
class CommonsNumbersInTwoSortedArraySol {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        List<Integer> res = new ArrayList<>();
        //corner case
        if (A.size() == 0 || B.size() == 0) {
            return res;
        }
        int i = 0;
        int j = 0;
        //termination condition
        while (i < A.size() && j < B.size()) {
            if (A.get(i) == B.get(j)) {
                res.add(A.get(i));
                i++;
                j++;
            } else if (A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
}
*/

/*
Method 2: Binary Search + HashSet
没有做成功
 */
class CommonsNumbersInTwoSortedArraySol {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<>();

        //corner case
        if (A.size() == 0 || B.size() == 0) {
            return result;
        }
        for (int i = 0; i < A.size(); i++) {
            int index = binarySearch(B, A.get(i));
            if (index != -1) {
                result.add(A.get(i));
                B.remove(B.get(index));
            }
        }
        return result;
    }

    private int binarySearch(List<Integer> list, Integer target) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}