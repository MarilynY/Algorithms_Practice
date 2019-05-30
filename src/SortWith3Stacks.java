import java.util.Deque;
import java.util.LinkedList;

public class SortWith3Stacks {
    public static void main(String[] args) {
        LinkedList<Integer> testcase1 = new LinkedList<>();
        testcase1.push(4);
        testcase1.push(2);
        testcase1.push(3);
        testcase1.push(4);
        testcase1.push(2);

        LinkedList<Integer> testcase2 = new LinkedList<>();
        testcase2.push(4);
        testcase2.push(2);
        testcase2.push(3);


        SortWith3StacksSolution1 test1 = new SortWith3StacksSolution1();
        SortWith3StacksSolution2 test2 = new SortWith3StacksSolution2();

        System.out.println("Method 1:");
        test1.sort1(testcase1);
        while(!testcase1.isEmpty()) {
           System.out.print(testcase1.pop() + " ");
        }

        System.out.println("\n" + "Method 2:");
        test2.sort2(testcase2);
        while(!testcase2.isEmpty()) {
            System.out.print(testcase2.pop() + " ");
        }
    }
}
//Time: O(n^2)
class SortWith3StacksSolution1 {
    public LinkedList<Integer> sort1(LinkedList<Integer> s1) {
        if (s1.isEmpty()) {
            return s1;
        }
        LinkedList<Integer> s2 = new LinkedList<>();
        LinkedList<Integer> s3 = new LinkedList<>();
        while (!s1.isEmpty()) {
            //globalMin
            int min = Integer.MAX_VALUE;
            //move elements from s1 to s2 and find globalMin in this process
            while(!s1.isEmpty()) {
                if (s1.peek() < min) {
                    min = s1.peek();
                }
                s2.push(s1.pop());
            }
            //move elements that are equal to target to s3
            //move the rest elements back to s1
            while(!s2.isEmpty()) {
                if (s2.peek() != min) {
                    s1.push(s2.pop());
                } else {
                    s3.push(s2.pop());
                }
            }
        }
        //move elements back to s1
        while(!s3.isEmpty()) {
            s1.push(s3.pop());
        }
        return s1;
    }
}

/**
 * The numbers are in s1 originally, after sorting, the numbers should be in
 * s1 as well and from top to bottom the numbers are sorted in ascending order.
 */
class SortWith3StacksSolution2 {
    //Assumption: s1 is not null
    public LinkedList<Integer> sort2(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<>();
        LinkedList<Integer> s3 = new LinkedList<>();
        sort(s1, s2, s3, s1.size());
        return s1;
    }
    private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2,
                      LinkedList<Integer> s3, int length) {
        //Step 1: split s1 equally
        //base case
        if (length <= 1) {
            return;
        }
        int mid1 = length / 2;
        int mid2 = length - length / 2;
        for (int i = 0; i < mid1; i++) {
            s2.offerFirst(s1.pollFirst());
        }
        //s2's length is mid1, s1's length is mid2

        //use the other stacks to sort s2/s1
        //after sorting the numbers in s2/s1 are in ascending order from
        //top to bottom in the two stacks
        //we just need to guarantee the first two are s1 and s2
        //the order of the rest two stacks do not matter
        //They are just buffers
        sort(s2, s3, s1, mid1);
        sort(s1, s3, s2, mid2);

        //Step 2: merger
        //i is the counter in s2, j is the counter in s1
        int i = 0;
        int j = 0;
        while (i < mid1 && j < mid2) {
            if (s2.peekFirst() <= s1.peekFirst()) {
                s3.offerFirst(s2.pollFirst());
                i++;
            } else {
                s3.offerFirst(s1.pollFirst());
                j++;
            }
        }
        //if s1 still has elements
        while (i < mid1) { // i is the pointer in s2
            s3.offerFirst(s2.pollFirst());
            i++; //don't forget
        }
        while (j < mid2) { //j is the pointer in s1
            s3.offerFirst(s1.pollFirst());
            j++;
        }
        //shuffle elements from s3 to s1
        //after merging, the numbers are in descending order from top to bottom
        //in s3, we need to push them back to s1 so that they are in ascending order
        //from top to bottom.
        for (int index = 0; index < length; index++) {
            s1.offerFirst(s3.pollFirst());
        }
        return; // return to last call stack
    }
}