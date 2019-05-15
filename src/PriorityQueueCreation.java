import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueCreation {
    public static void main(String[] args) {
        //create a PQ
        Queue<Integer> pq = new PriorityQueue<>();
        //APIs similar with queue, but overwritten by PriorityQueue
        //offer
        pq.offer(1);
        pq.offer(2);
        pq.offer(3);
        System.out.println(pq.peek()); // 1
        //poll
        pq.poll(); // 1
        System.out.println(pq.peek()); // 2
        //isEmpty
        System.out.println(pq.isEmpty()); // false
        //size
        System.out.println(pq.size()); // 2
        //peek
        System.out.println(pq.peek()); // 2
        //remove
        System.out.println(pq.remove()); // 2
        System.out.println(pq.peek()); // 3
    }
}
