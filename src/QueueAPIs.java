import java.util.LinkedList;
import java.util.Queue;

public class QueueAPIs {
    public static void main(String[] args) {
        //create a queue
        Queue<Integer> q = new LinkedList<>();
        //q: 3 5 7 0 1
        q.offer(3);
        q.offer(5);
        q.offer(7);
        q.offer(0);
        q.offer(1);

        System.out.println(q);
        System.out.println(q.size());
        System.out.println(q.poll());
        System.out.println(q);
        q.offer(100);
        System.out.println(q);
        System.out.println(q.isEmpty());
        System.out.println(q.peek());

    }
}
