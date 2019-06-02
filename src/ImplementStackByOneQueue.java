import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackByOneQueue {
    public static void main(String[] args) {
        ImplementStackByOneQueueSolution testQ = new ImplementStackByOneQueueSolution();

        testQ.offerFirst(1);
        testQ.offerFirst(2);
        testQ.offerFirst(3);
        testQ.offerFirst(4);
        testQ.offerFirst(5);
        System.out.println("originial testQ is: ");
        System.out.println("q:" + testQ.q);

        testQ.offerFirst(6);
        System.out.println("After offer 6: ");
        System.out.println("q:" + testQ.q);

        System.out.println("After check size: ");
        System.out.println(testQ.size());

        System.out.println("test isEmpty(): ");
        System.out.println("Test isEmpty():" + testQ.isEmpty());

        System.out.println(testQ.pollFirst()); //6 last in == 6 so first out == 6
        System.out.println("q:" + testQ.q);

        System.out.println(testQ.pollFirst()); //5
        System.out.println("q:" + testQ.q);

        System.out.println(testQ.peekFirst()); //4
        System.out.println("q:" + testQ.q);

        testQ.offerFirst(7);
        testQ.offerFirst(8);
        System.out.println("q:" + testQ.q);
        System.out.println(testQ.pollFirst()); //8
        System.out.println(testQ.peekFirst()); //7
        System.out.println(testQ.pollFirst()); //7
        System.out.println("q:" + testQ.q);
        System.out.println(testQ.pollFirst());//4
        System.out.println(testQ.pollFirst());//3
        System.out.println(testQ.pollFirst());//2
        System.out.println(testQ.size());//1
        System.out.println(testQ.isEmpty());//false
        System.out.println(testQ.pollFirst());//1
        System.out.println(testQ.size());//0
        System.out.println(testQ.isEmpty());//true
        System.out.println(testQ.pollFirst());//null
        System.out.println(testQ.peekFirst());//null
        testQ.offerFirst(1);
        System.out.println("q:" + testQ.q);
    }
}

class ImplementStackByOneQueueSolution {
    Queue<Integer> q;
    public ImplementStackByOneQueueSolution() {
        q = new LinkedList<>();
    }
    public void offerFirst(int element) {
        q.offer(element);
    }
    public Integer pollFirst() {
        if (q.size() == 0) {
            return null;
        }
        //can not use while (q.size() > 1) dead loop
        for (int i = 0; i < q.size() - 1; i++ ) {
            q.offer(q.poll());
        }
        return q.poll();
    }
    public Integer peekFirst() {
        if (q.size() == 0) {
            return null;
        }
        int temp = 0;
        for (int i = 0; i < q.size(); i++){
            temp = q.poll();
            q.offer(temp);
        }
        return temp;
    }
    public int size() {
        return q.size();
    }
    public boolean isEmpty() {
        return q.isEmpty();
    }
}