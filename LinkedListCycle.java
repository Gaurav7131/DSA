
public class LinkedListCycle {
    // Defn of Singly Linked List node
    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasNode(ListNode head) {
        // single node pointing to null cannot have a cycle
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Traverse as long as Fast has valid step
        while (fast != null && fast.next != null) {
            slow = slow.next; // 1 step
            fast = fast.next.next;// 2 step
        }

        // if fast and slow meet at exact same ref.point
        if (slow == fast) {
            return true;

        }

        // reached at the end of list without any cycle
        return false;

    }

    public static void main(String[] args) {
        LinkedListCycle solver = new LinkedListCycle();

        // 3 -> 2 -> 0 -> -4
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head.next = node2;
        head.next = node3;
        head.next = node4;

        boolean result = solver.hasNode(head);
        System.out.println("Result:" + result);
    }
}
