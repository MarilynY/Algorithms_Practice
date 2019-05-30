import java.util.Deque;
import java.util.LinkedList;

public class SortWith2Stacks {
    public static void main(String[] args) {
        Deque<Integer> s1 = new LinkedList<>();
        s1.push(4);
        s1.push(2);
        s1.push(5);
        s1.push(4);
        s1.push(2);
        s1.push(0);
        s1.push(-5);
        s1.push(100);
        s1.push(9);
        s1.push(4);
        s1.push(100);

        SortWith2StacksSolution test = new SortWith2StacksSolution();
        test.sortWith2Stacks(s1);
        while(!s1.isEmpty()) {
            System.out.print(s1.pop() + " ");
        }
    }
}

class SortWith2StacksSolution {
    public Deque<Integer> sortWith2Stacks(Deque<Integer> s1) {
        Deque<Integer> s2 = new LinkedList<>();
        while(!s1.isEmpty()) {
            int value = s1.pop();
            //must use while here
            //use while when there is duplication
            while (!s2.isEmpty() && value < s2.peek()) {
                //move the element back to s1
                s1.push(s2.pop());
            }
            s2.push(value);
        }
        //move elements back to s1
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return s1;
    }
}
