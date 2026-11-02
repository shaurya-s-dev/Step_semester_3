package linked_list.class_problems;

/**
 * Problem 4: Find Intersection Node of Two Linked Lists
 *
 * TASK:
 * Implement findIntersection(a, b) that finds the first shared node of two singly linked lists.
 * Must run in O(1) additional space.
 */
public class IntersectionOfLinkedLists {

    public static ListNode findIntersection(ListNode a, ListNode b) {
        if (a == null || b == null) return null;

        int lenA = getLength(a);
        int lenB = getLength(b);

        ListNode currA = a;
        ListNode currB = b;

        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                currA = currA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                currB = currB.next;
            }
        }

        while (currA != null && currB != null) {
            if (currA == currB) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }

        return null;
    }

    private static int getLength(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }
}
