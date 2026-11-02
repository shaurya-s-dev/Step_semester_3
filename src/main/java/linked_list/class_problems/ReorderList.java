package linked_list.class_problems;

/**
 * Problem 5: Reorder Linked List Alternately from Ends
 *
 * TASK:
 * In-place rearrangement: L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 ...
 * Techniques combined:
 * 1. Fast & slow pointers to find the middle.
 * 2. In-place reversal of the second half.
 * 3. Alternating merge of first half and reversed second half.
 */
public class ReorderList {

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        // 1. Find middle
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Split and reverse second half
        ListNode secondHalf = slow.next;
        slow.next = null; // detach first half
        secondHalf = reverse(secondHalf);

        // 3. Alternating merge
        ListNode p1 = head;
        ListNode p2 = secondHalf;

        while (p2 != null) {
            ListNode t1 = p1.next;
            ListNode t2 = p2.next;

            p1.next = p2;
            p2.next = t1;

            p1 = t1;
            p2 = t2;
        }
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
