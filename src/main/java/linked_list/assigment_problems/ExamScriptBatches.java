package linked_list.assigment_problems;

/**
 * Problem 2: Exam Script Batches
 *
 * TASK:
 * Reverse the list in groups of k nodes. A final group with fewer than k nodes stays in original order.
 * Implement Node reverseInGroups(Node head, int k) by changing links only.
 * No new nodes, no arrays.
 */
public class ExamScriptBatches {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static Node reverseInGroups(Node head, int k) {
        if (head == null || k <= 1) return head;

        Node dummy = new Node(0);
        dummy.next = head;

        Node prevGroupEnd = dummy;

        while (true) {
            // 1. Check if k nodes exist starting from prevGroupEnd.next
            Node kth = prevGroupEnd;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }

            if (kth == null) {
                // Fewer than k nodes remaining, leave in original order
                break;
            }

            Node nextGroupStart = kth.next;

            // 2. Reverse k nodes from prevGroupEnd.next to kth
            Node curr = prevGroupEnd.next;
            Node prev = nextGroupStart;
            Node groupHead = curr;

            for (int i = 0; i < k; i++) {
                Node nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }

            // 3. Connect previous group end to the new reversed group head (prev)
            prevGroupEnd.next = prev;
            prevGroupEnd = groupHead;
        }

        return dummy.next;
    }

    public static Node buildList(int... values) {
        if (values == null || values.length == 0) return null;
        Node dummy = new Node(0);
        Node curr = dummy;
        for (int v : values) {
            curr.next = new Node(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static String toDisplayString(Node head) {
        if (head == null) return "null";
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            sb.append(curr.data).append(" -> ");
            curr = curr.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
