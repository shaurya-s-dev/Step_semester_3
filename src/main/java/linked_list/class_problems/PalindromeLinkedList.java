package linked_list.class_problems;

/**
 * Problem 2: Check if a Linked List is a Palindrome
 *
 * TASK:
 * Implement isPalindrome(head) that determines if a singly linked list reads
 * the same forwards and backwards in O(n) time and O(1) extra space.
 */
public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // 1. Find middle with slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode secondHalf = reverseList(slow.next);

        // 3. Compare first half and reversed second half
        ListNode p1 = head;
        ListNode p2 = secondHalf;
        boolean isPalin = true;
        while (p2 != null) {
            if (p1.val != p2.val) {
                isPalin = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Optional restore
        slow.next = reverseList(secondHalf);

        return isPalin;
    }

    private static ListNode reverseList(ListNode head) {
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
