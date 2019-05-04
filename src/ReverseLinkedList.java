
/*
Algorithms： Recursion
Assume 从N2到N4已经是翻转好的了， 那么把N1连接上就好了
N1→  | N2 ← N3 ← N4
head            head1

head.next.next = head
head.next = null

Time: O(n)
Space: O(n) for call stack
*/


class ReverseLinkedListSolution {
    public ListNode reverseLinkedList(ListNode head) {
        //corner case: has no elements or one element
        if (head == null || head.next == null) {
            return head;
        }

        //recursion rule
        ListNode head1 = reverseLinkedList(head.next);

        //current layer logic
        head.next.next = head;
        head.next = null;

        return head1;
    }
}

//Test case
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null; //勿忘

        ReverseLinkedListSolution test = new ReverseLinkedListSolution();
        ListNode newHead = test.reverseLinkedList(node1);

        while(newHead != null) {
            System.out.print(newHead.value + " ");
            newHead= newHead.next; //调用next之前，查NPE
        }
    }
}