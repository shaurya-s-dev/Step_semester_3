package linked_list.assigment_problems;

/**
 * Problem 5: Cancelling the k-th Last Order
 *
 * TASK:
 * A restaurant keeps today's orders in a singly linked list, newest at the end.
 * A customer cancels the order that is k-th from the end.
 *
 * Implement Node removeKthFromEnd(Node head, int k) that removes that node in a single pass
 * and returns the head.
 *
 * CONSTRAINTS:
 * - 1 <= k <= length of list <= 10^4
 * - Single pass only
 *
 * COMPLEXITY:
 * - Time Complexity: O(n) where n is the length of the list. The lead pointer visits each node
 *   in a single forward pass without rewinding or counting passes.
 * - Auxiliary Space Complexity: O(1). Only a single dummy node and two pointer references
 *   (lead and trail) are used.
 * - Removing the Head Without Special Case:
 *   By attaching a dummy node before head (`dummy.next = head`) and initializing both `lead`
 *   and `trail` at `dummy`, advancing `lead` by k + 1 positions ensures that when `lead` reaches
 *   null (off the end), `trail` is guaranteed to be pointing to the predecessor of the target node.
 *   If the head itself is the k-th node from the end (k == n), `trail` remains at `dummy`, so
 *   `trail.next = trail.next.next` seamlessly removes `head` and returns `dummy.next` without any
 *   branching or edge-case `if` statements.
 */
public class CancelKthOrder {

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
     * Removes the k-th node from the end in a single pass using two pointers.
     *
     * @param head head of the singly linked list
     * @param k 1-based index from the end
     * @return head of the list after removal
     */
    public static Node removeKthFromEnd(Node head, int k) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node lead = dummy;
        Node trail = dummy;

        // Advance lead by k + 1 steps to create a gap of k nodes between lead and trail
        for (int i = 0; i <= k; i++) {
            if (lead == null) {
                // If k exceeds list length, nothing removed or returns head
                return head;
            }
            lead = lead.next;
        }

        // Move both pointers forward until lead falls off the end
        while (lead != null) {
            lead = lead.next;
            trail = trail.next;
        }

        // trail is now right before the node to be removed
        if (trail.next != null) {
            trail.next = trail.next.next;
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
