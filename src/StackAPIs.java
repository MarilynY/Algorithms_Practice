import java.util.Deque;
import java.util.LinkedList;

public class StackAPIs {
    public static void main(String[] args) {
        //create a stack
        Deque<Integer> stack = new LinkedList<>();
        //  | 4 3 7 1 -->
        stack.push(4);
        stack.push(3);
        stack.push(7);
        stack.push(1);
        System.out.println(stack); //[1, 7, 4, 3]
        System.out.println(stack.size());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
        stack.push(100);
        System.out.print(stack);
    }
}
