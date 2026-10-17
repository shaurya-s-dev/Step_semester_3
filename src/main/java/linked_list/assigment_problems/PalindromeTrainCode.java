package linked_list.assigment_problems;

/**
 * Problem 10: The Palindrome Train Code
 *
 * TASK:
 * Each train has a code stored as a singly linked list of digits. Codes that read the same
 * from both ends are reserved for special trains. The check must use constant extra space,
 * and the list must be left exactly as it was.
 *
 * Implement boolean isPalindrome(Node head) in O(n) time and O(1) extra space, restoring
 * the list before returning.
 *
 * CONSTRAINTS:
 * - 1 <= length of list <= 10^5
 * - O(1) additional space; no array or stack copies
 * - The list must be unchanged after the call
 *
 * COMPLEXITY:
 * - Time Complexity: O(n) where n is the length of the list.
 *   - Finding middle: n/2 steps using slow/fast pointers.
 *   - Reversing second half: n/2 steps.
 *   - Comparing two halves: n/2 steps.
 *   - Re-reversing second half to restore: n/2 steps.
 *   Total time is approx 2n operations = O(n).
 * - Auxiliary Space Complexity: O(1). Only a constant number of pointer variables (slow, fast,
 *   prev, curr, next) are used.
 * - Comparison with Copying into an Array:
 *   Copying values into an array requires O(n) additional heap space to store the copy,
 *   which violates the O(1) space constraint for large inputs (n = 10^5). The in-place pointer
 *   reversal achieves strict O(1) auxiliary space while guaranteeing complete restoration of the original list.
 */
public class PalindromeTrainCode {

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
     * Determines whether the given singly linked list of digits is a palindrome.
     * Restores the linked list to its original configuration before returning.
     *
     * @param head head of the singly linked list
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 1. Find the middle node (for even lists, the end of first half)
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half starting after slow
        Node secondHalfHead = reverseList(slow.next);

        // 3. Compare first half with reversed second half
        Node p1 = head;
        Node p2 = secondHalfHead;
        boolean isPalin = true;

        while (p2 != null) {
            if (p1.data != p2.data) {
                isPalin = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 4. Restore the original list structure by reversing the second half again
        slow.next = reverseList(secondHalfHead);

        return isPalin;
    }

    private static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
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
