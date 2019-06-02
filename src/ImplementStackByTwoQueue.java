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

        System.out.println("Test pollFirst method:" + testQ.pollFirst()); //5

        System.out.println("Test peekFirst method:" + testQ.peekFirst()); //3

        testQ.offerFirst(7);
        testQ.offerFirst(8);
        System.out.println("q1:" + testQ.q1 + " q2:" + testQ.q2);
        System.out.println(testQ.pollFirst());
        System.out.println(testQ.peekFirst());
        System.out.println(testQ.pollFirst());
        System.out.println("q1:" + testQ.q1 + " q2:" + testQ.q2);
        System.out.println(testQ.pollFirst());
        System.out.println(testQ.pollFirst());
        System.out.println(testQ.pollFirst());
        System.out.println(testQ.size());
        System.out.println(testQ.isEmpty());
        System.out.println(testQ.peekFirst());
    }
}


class ImplementStackByTwoQueueSolution {
    //offer the new elements in to q1
    Queue<Integer> q1;
    //keep polling from q1 until q1 is empty, return the last element
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
        if (q1.isEmpty() && q2.isEmpty()) {
            return null;
        }
        int temp = 0;
        //一定要先check q1， 因为new elements每次都是放在q1
        if (!q1.isEmpty()) {
            while (q1.size() > 1) {
                temp = q1.poll();
                q2.offer(temp);
            }
            return q1.poll();
        } else {
            while (q2.size() > 1) {
                temp = q2.poll();
                q1.offer(temp);
            }
            return q2.poll();
        }
    }

    public Integer peekFirst() {
        if (q1.isEmpty() && q2.isEmpty()) {
            return null;
        }
        int temp = 0;
        if (!q1.isEmpty()) {
            while (q1.size() > 1) {
                temp = q1.poll();
                q2.offer(temp);
            }
            return q1.poll();
        } else {
            while (q2.size() > 1) {
                temp = q2.poll();
                q1.offer(temp);
            }
            return q2.poll();
        }
    }

    public Integer size() {
        return q1.size() + q2.size();
    }

    public boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}