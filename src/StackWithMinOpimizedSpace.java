import java.util.Deque;
import java.util.LinkedList;

public class StackWithMinOpimizedSpace {
    public static void main(String[] args) {
        StackWithMinOpimizedSpaceSolutoin stack = new StackWithMinOpimizedSpaceSolutoin();
        stack.push(7);
        stack.push(2);
        stack.push(1);
        stack.push(2);
        stack.push(9);
        stack.push(1);
        stack.push(0);
        stack.push(2);
        System.out.println(stack.stack + " " + stack.minStack + " " + stack.sizeStack);
        System.out.println(stack.pop());//2
        System.out.println(stack.stack + " " + stack.minStack + " " + stack.sizeStack);
        System.out.println(stack.min());//0
        System.out.println(stack.stack + " " + stack.minStack + " " + stack.sizeStack);
        System.out.println(stack.pop());//0
        System.out.println(stack.stack + " " + stack.minStack + " " + stack.sizeStack);
        System.out.println(stack.min());//1
        System.out.println(stack.stack + " " + stack.minStack + " " + stack.sizeStack);
        System.out.println(stack.pop());//1
        System.out.println(stack.stack + " " + stack.minStack + " " + stack.sizeStack);
        System.out.println(stack.min()); //1
        System.out.println(stack.stack + " " + stack.minStack + " " + stack.sizeStack);
        System.out.println(stack.pop());//9
        System.out.println(stack.stack + " " + stack.minStack + " " + stack.sizeStack);
        System.out.println(stack.min());//1
        System.out.println(stack.stack + " " + stack.minStack + " " + stack.sizeStack);
        System.out.println(stack.pop());//2
        System.out.println(stack.stack + " " + stack.minStack + " " + stack.sizeStack);
        System.out.println(stack.min());//1
        System.out.println(stack.stack + " " + stack.minStack + " " + stack.sizeStack);
        System.out.println(stack.pop());//1
        System.out.println(stack.stack + " " + stack.minStack + " " + stack.sizeStack);
        System.out.println(stack.min()); //2
        System.out.println(stack.stack + " " + stack.minStack + " " + stack.sizeStack);
        System.out.println(stack.pop());//2
        System.out.println(stack.stack + " " + stack.minStack + " " + stack.sizeStack);
        System.out.println(stack.min());//7
        System.out.println(stack.stack + " " + stack.minStack + " " + stack.sizeStack);
        System.out.println(stack.pop());//7
        System.out.println(stack.stack + " " + stack.minStack + " " + stack.sizeStack);
        System.out.println(stack.min());//-1
        System.out.println(stack.stack + " " + stack.minStack + " " + stack.sizeStack);
    }
}

class StackWithMinOpimizedSpaceSolutoin {
    Deque<Integer> stack;
    Deque<Integer> minStack;
    Deque<Integer> sizeStack;
    public StackWithMinOpimizedSpaceSolutoin() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        sizeStack = new LinkedList<>();
    }
    public void push(int element) {
        stack.push(element);
        while (minStack.isEmpty() || element < minStack.peek()) { //not <=
            minStack.push(element);
            sizeStack.push(stack.size());
        }
    }
    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        if (stack.size() <= sizeStack.peek()) {
            minStack.pop();
            sizeStack.pop();
        }
        return stack.pop();
    }
    public int min() {
        if (stack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }
}