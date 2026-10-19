class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkListCycleII {
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Determine the cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // both runner meet at same point
            if (slow == fast) {
                ListNode entry = head;

                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;// Etry point found
            }
        }
        return null;// No cycle detected
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode nodeNeg4 = new ListNode(-4);

        head.next = node2;
        node2.next = node0;
        node0.next = nodeNeg4;
        nodeNeg4.next = node2; // creates cycle back to node with value 2

        ListNode cycleStart = detectCycle(head);
        if (cycleStart != null) {
            System.out.println("Cycle begins at node with value: " + cycleStart.val); // Expected: 2
        } else {
            System.out.println("No cycle detected.");
        }

        // List with no cycle [1, 2] -> null
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        ListNode noCycle = detectCycle(head2);
        System.out.println("No cycle test output: " + noCycle);

    }
}
