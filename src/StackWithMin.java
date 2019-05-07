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
        if (minStack.isEmpty() || value <= minStack.peek()) {  //!!这里必须有等于，否则有重复最小值的时候，min就会出错了
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
        /*如果这么写，就不用.equals()
        int temp = stack.pop();
        if (temp == minStack.peek()) {
          minStack.pollFirst();
        }
        return temp;
        */
        if (stack.peek().equals(minStack.peek())){            //!!这里不是用==
            minStack.pop();
        }
        return stack.pop();
    }
    //min() - O(1)
    public int min() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
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
        stack.push(2);
        stack.push(9);
        stack.push(1);
        stack.push(0);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.min());
        System.out.println(stack.pop());
        System.out.println(stack.min());
        System.out.println(stack.pop());
        System.out.println(stack.min()); //如果上面不是<= , 这里就会return 2 而不是1了
        System.out.println(stack.peek());
        stack.push(0);
        System.out.println(stack.peek());
        System.out.println(stack.min());
        stack.push(100);
        System.out.println(stack.peek());
        System.out.println(stack.min());
    }
}
