package linked_list.assigment_problems;

/**
 * Problem 4: Library Returns by Due Day
 *
 * TASK:
 * Sort returned books chain by due day using merge sort on the linked list.
 * Change links only; do not copy values into an array.
 * Stable sort: books with the same due day keep their drop order.
 */
public class LibraryReturnsMergeSort {

    public static class Node {
        public String title;
        public int day;
        public Node next;

        public Node(String title, int day) {
            this.title = title;
            this.day = day;
            this.next = null;
        }

        public Node(String title, int day, Node next) {
            this.title = title;
            this.day = day;
            this.next = next;
        }
    }

    public static Node sortByDueDay(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 1. Split the list into two halves using slow and fast pointers
        Node prev = null;
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Cut the link after the first half
        prev.next = null;

        // 2. Sort both halves
        Node left = sortByDueDay(head);
        Node right = sortByDueDay(slow);

        // 3. Merge sorted halves stably (on ties, pick from left)
        return merge(left, right);
    }

    private static Node merge(Node l1, Node l2) {
        Node dummy = new Node("", 0);
        Node tail = dummy;

        while (l1 != null && l2 != null) {
            // Stable sort: take from left half if day is smaller or equal
            if (l1.day <= l2.day) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null) {
            tail.next = l1;
        } else if (l2 != null) {
            tail.next = l2;
        }

        return dummy.next;
    }

    public static String toDisplayString(Node head) {
        if (head == null) return "null";
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            sb.append(curr.title).append(":").append(curr.day).append(" -> ");
            curr = curr.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
