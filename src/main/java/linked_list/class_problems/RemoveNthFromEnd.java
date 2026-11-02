package linked_list.class_problems;

/**
 * Problem 1: Remove the N-th Node From the End of a Linked List
 *
 * TASK:
 * Implement removeNthFromEnd(head, n) that removes the node located 'n' positions
 * from the end of a singly linked list and returns the head of the modified list.
 * Must achieve this in a single pass.
 *
 * Edge case handling:
 * A dummy node is placed before head (dummy.next = head). Fast pointer is advanced
 * n + 1 steps ahead of slow pointer. When fast reaches null, slow is right before
 * the node to remove, even if the node to remove is the head itself.
 */
public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            if (fast == null) return head;
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return dummy.next;
    }
}
