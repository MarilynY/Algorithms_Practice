import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackByTwoQueue {
    public static void main(String[] args) {
        ImplementStackByTwoQueueSolution testQ = new ImplementStackByTwoQueueSolution();

        testQ.offerFirst(1);
        testQ.offerFirst(2);
        testQ.offerFirst(3);
        testQ.offerFirst(4);
        testQ.offerFirst(5);
        System.out.println("originial testQ is: ");
        System.out.println("q1:" + testQ.q1 + " q2:" + testQ.q2);

        testQ.offerFirst(6);
        System.out.println("After offer 6: ");
        System.out.println("q1:" + testQ.q1 + " q2:" + testQ.q2);

        System.out.println("After check size: ");
        System.out.println(testQ.size());

        System.out.println("test isEmpty(): ");
        System.out.println("Test isEmpty():" + testQ.isEmpty());

        System.out.println(testQ.pollFirst()); //6 last in == 6 so first out == 6
        System.out.println("q1:" + testQ.q1 + " q2:" + testQ.q2);

        System.out.println(testQ.pollFirst()); //5
        System.out.println("q1:" + testQ.q1 + " q2:" + testQ.q2);

        System.out.println(testQ.peekFirst()); //4
        System.out.println("q1:" + testQ.q1 + " q2:" + testQ.q2);

        testQ.offerFirst(7);
        testQ.offerFirst(8);
        System.out.println("q1:" + testQ.q1 + " q2:" + testQ.q2);
        System.out.println(testQ.pollFirst()); //8
        System.out.println(testQ.peekFirst()); //7
        System.out.println(testQ.pollFirst()); //7
        System.out.println("q1:" + testQ.q1 + " q2:" + testQ.q2);
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
        System.out.println("q1:" + testQ.q1 + " q2:" + testQ.q2);
    }
}


class ImplementStackByTwoQueueSolution {
    //offer the new elements in to q1
    Queue<Integer> q1;
    //keep polling from q1 until one element left. Then return that element and swap s1 and s2
    Queue<Integer> q2;
    //constructor
    public ImplementStackByTwoQueueSolution() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void offerFirst(int element) {
        q1.offer(element);
    }

    public Integer pollFirst() {
        if (q1.isEmpty()) {
            return null;
        }
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int res = q1.poll();
        swap();
        return res;
    }

    public Integer peekFirst() {
        if (q1.isEmpty()) {
            return null;
        }
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int res = q1.poll();
        //peekFirst is different than pollFirst
        //we need to put the last element back to q2 also
        q2.offer(res);
        swap();
        return res;
    }

    public Integer size() {
        return q1.size() + q2.size();
    }

    public boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }
    private void swap () {
        Queue<Integer> tempQ = q1;
        q1 = q2;
        q2 = tempQ;
    }
}