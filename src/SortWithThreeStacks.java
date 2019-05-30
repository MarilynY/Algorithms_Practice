
import java.util.LinkedList;

//xinyi 打印版
public class SortWithThreeStacks {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        LinkedList<Integer> s3 = new LinkedList<Integer>();
        sort(s1, s2, s3, s1.size());
    }

    private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int length) {

        System.out.println("s1 is: " + s1);
        System.out.println("s2 is: " + s2);
        System.out.println("s3 is: " + s3 + " ");
        System.out.println();

        if(length <= 1) {
            System.out.println("length == 1, returning");
            return;
        }
        int mid1 = length / 2;
        int mid2 = length - length / 2;
        for(int i = 0; i < mid1; i++) {
            s2.offerFirst(s1.pollFirst());
        }

        System.out.println("s1 is: " + s1);
        System.out.println("s2 is: " + s2);
        System.out.println("s3 is: " + s3 + " ");
        System.out.println("Entering first recursion call, mid1 is: " + mid1);
        //use the other stacks to sort s2/s1
        // after sorting the numbers in s2/s1 are in ascending order from top to
        // bottom in the two stacks.
        sort(s2, s1, s3, mid1);
        System.out.println("Before second recursion call");
        System.out.println("s1 is: " + s1);
        System.out.println("s2 is: " + s2);
        System.out.println("s3 is: " + s3 + " ");
//		System.out.println(mid1 + " " + mid2);
        System.out.println("Entering second recursion call, mid2 is: " + mid2);
        sort(s1, s2, s3, mid2);

        int i = 0;
        int j = 0;
        System.out.println("s1 is: " + s1);
        System.out.println("s2 is: " + s2);
        System.out.println("s3 is: " + s3);
        System.out.println("mid1 is " + mid1 + " mid2 is " + mid2);
        System.out.println();

        while(i < mid1 && j < mid2) {
            if(s2.peekFirst() < s1.peekFirst()) {
                s3.offerFirst(s2.pollFirst());
                i++;
            } else {
                s3.offerFirst(s1.pollFirst());
                j++;
            }
        }
        while(i < mid1) {
            s3.offerFirst(s2.pollFirst());
            i++;
        }
        while(j < mid2) {
            s3.offerFirst(s1.pollFirst());
            j++;
        }
        System.out.println("after while loop: ");
        System.out.println("s1 is: " + s1);
        System.out.println("s2 is: " + s2);
        System.out.println("s3 is: " + s3);
        System.out.println();
        // after merging, the numbers are in descending order from top to bottom
        // in s3, we need to push them back to s1 so that they are in ascending order
//		System.out.println(length);
        for(int index = 0; index < length; index++) {
            s1.offerFirst(s3.pollFirst());
        }
    }
    public static void main(String[] args) {
        LinkedList<Integer> s1 = new LinkedList<Integer>();
        s1.offerFirst(3);
        s1.offerFirst(5);
        s1.offerFirst(1);
        s1.offerFirst(7);
        s1.offerFirst(9);
        s1.offerFirst(2);
        System.out.println("printing s1: " + s1);

        SortWithThreeStacks SortWithThreeStacksObj = new SortWithThreeStacks();
        SortWithThreeStacksObj.sort(s1);
        System.out.println("res is: " + s1);
//		int size = s1.size();
//		for(int i = 0; i < size; i++) {
//			System.out.print(s1.pollFirst());
//		}
    }
}