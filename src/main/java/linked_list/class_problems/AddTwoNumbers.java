package linked_list.class_problems;

/**
 * Problem 3: Add Two Numbers Represented by Linked Lists
 *
 * TASK:
 * Given two linked lists representing numbers in reverse order (e.g. 2 -> 4 -> 3 is 342),
 * add them and return the sum as a linked list in reverse order.
 */
public class AddTwoNumbers {

    public static ListNode addNumbers(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (a != null || b != null || carry != 0) {
            int sum = carry;
            if (a != null) {
                sum += a.val;
                a = a.next;
            }
            if (b != null) {
                sum += b.val;
                b = b.next;
            }

            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        return dummy.next;
    }
}
