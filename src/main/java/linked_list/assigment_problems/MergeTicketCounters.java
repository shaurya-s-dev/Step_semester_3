package linked_list.assigment_problems;

/**
 * Problem 2: Merging Two Ticket Counters
 *
 * TASK:
 * Two railway counters each produce a singly linked list of ticket numbers in ascending order.
 * At closing time, both lists must be combined into one ascending list.
 *
 * Implement Node mergeSorted(Node a, Node b) that merges the lists by relinking the existing nodes
 * and returns the new head. Duplicates are kept.
 *
 * CONSTRAINTS:
 * - 0 <= length of each list <= 10^5
 * - No new nodes may be created (a single dummy node is allowed)
 *
 * COMPLEXITY:
 * - Time Complexity: O(m + n) where m and n are the lengths of the two lists.
 *   Each node from both lists is inspected and relinked exactly once.
 * - Auxiliary Space Complexity: O(1). Only a single dummy node and a few pointer variables are used.
 *   No extra nodes or arrays are allocated.
 * - Comparison with Array Copying: Copying both lists into an array of size (m + n) and sorting it
 *   takes O((m + n) log(m + n)) time and O(m + n) extra space. The in-place two-pointer relinking
 *   technique is strictly superior: O(m + n) time and O(1) space.
 */
public class MergeTicketCounters {

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

    /**
     * Merges two ascending singly linked lists into a single ascending list by relinking existing nodes.
     *
     * @param a head of first sorted list
     * @param b head of second sorted list
     * @return head of the merged sorted list
     */
    public static Node mergeSorted(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node dummy = new Node(0);
        Node tail = dummy;

        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        if (a != null) {
            tail.next = a;
        } else if (b != null) {
            tail.next = b;
        }

        return dummy.next;
    }

    // Helper methods for constructing and displaying lists
    public static Node fromArray(int... values) {
        if (values == null || values.length == 0) return null;
        Node head = new Node(values[0]);
        Node curr = head;
        for (int i = 1; i < values.length; i++) {
            curr.next = new Node(values[i]);
            curr = curr.next;
        }
        return head;
    }

    public static String toDisplayString(Node head) {
        if (head == null) return "(empty)";
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            sb.append(curr.data);
            if (curr.next != null) {
                sb.append(" -> ");
            }
            curr = curr.next;
        }
        return sb.toString();
    }
}
