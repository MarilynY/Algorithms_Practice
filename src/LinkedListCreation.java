public class LinkedListCreation {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null; //勿忘

        while(node1 != null) {
            System.out.print(node1.value + " ");
            node1 = node1.next; //调用next之前，查NPE
        }
    }
}

class ListNode {
    //field
    ListNode next;
    int value;

    //constructor
    public ListNode(int x) {
        value = x;
    }
}
