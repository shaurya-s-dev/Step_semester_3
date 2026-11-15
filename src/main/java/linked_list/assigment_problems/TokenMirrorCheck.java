package linked_list.assigment_problems;

/**
 * Problem 5: Token Mirror Check
 *
 * TASK:
 * A kiosk prints a chain of token numbers and wants to know whether the chain reads
 * the same from both ends. Memory on the kiosk is very limited.
 * Implement boolean isPalindrome(Node head) using O(1) extra space.
 * You may temporarily change links, but the list must be exactly as it was when the method returns.
 * Write your own node class with data and next fields; do not use java.util.LinkedList.
 *
 * Output format:
 * Palindrome: true/false
 * List after check: ... -> null
 *
 * CONSTRAINTS:
 * - 0 <= length of list <= 10^5
 * - Use O(1) extra space
 *
 * COMPLEXITY:
 * - Time Complexity: O(n) where n is the length of the list.
 * - Auxiliary Space Complexity: O(1).
 * - Why array/stack copying fails the requirement:
 *   Copying into an array or stack uses O(n) additional space, which violates the strict O(1) memory requirement.
 */
public class TokenMirrorCheck {

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

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 1. Find the end of the first half with slow and fast pointers
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half
        Node secondHalfHead = reverseList(slow.next);

        // 3. Compare the two halves node by node
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

        // 4. Reverse the second half again and reattach it to restore original list
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
