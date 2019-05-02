import java.util.Deque;
import java.util.LinkedList;

public class StackWithMin {
    //field
    Deque<Integer> stack;
    Deque<Integer> minStack;

    //constructor
    public StackWithMin() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }
    //push()
    //if value < top of minStack -> push it in both stack
    //if minStack is empty, push it in anyway
    public void push(int value) {
        stack.push(value);
        if (minStack.isEmpty() || value < minStack.peek()) {
            minStack.push(value);
        }
    }
    //pop()
    //if top element of stack == top element of minStack -> pop both
    //else pop stack only
    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        if (stack.peek() == minStack.peek()) {
            minStack.pop();
        }
        return stack.pop();
    }
    //min() - O(1)
    public int min() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.pop();
    }
    //peek
    public int peek() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }
}

class testStackWithMin {
    public static void main(String[] args) {

        StackWithMin stack = new StackWithMin();
        stack.push(7);
        stack.push(2);
        stack.push(1);
        stack.push(9);
        stack.push(0);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.min());
        System.out.println(stack.pop());
        System.out.println(stack.min()); //bug
    }
}
