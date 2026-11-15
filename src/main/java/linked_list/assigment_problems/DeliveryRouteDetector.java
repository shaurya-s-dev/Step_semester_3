package linked_list.assigment_problems;

/**
 * Problem 1: Delivery Route Loop Detector
 *
 * TASK:
 * Detect whether the route has a loop, and if so, report the stop where the loop starts
 * and how many stops are in the loop.
 * Output: "Loop: no" or "Loop: yes, starts at stop s, length k."
 *
 * Constraints:
 * O(1) extra space: no HashSet, no visited flags, no changes to nodes.
 */
public class DeliveryRouteDetector {

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

    public static String detectLoop(Node head) {
        if (head == null || head.next == null) {
            return "Loop: no";
        }

        Node slow = head;
        Node fast = head;
        boolean hasLoop = false;

        // Floyd's Cycle-Finding Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasLoop = true;
                break;
            }
        }

        if (!hasLoop) {
            return "Loop: no";
        }

        // Find the start of the loop
        Node p1 = head;
        Node p2 = slow;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        Node loopStartNode = p1;

        // Find the length of the loop
        int length = 1;
        Node curr = loopStartNode.next;
        while (curr != loopStartNode) {
            length++;
            curr = curr.next;
        }

        return "Loop: yes, starts at stop " + loopStartNode.data + ", length " + length;
    }

    public static Node buildRoute(int[] stops, int pos) {
        if (stops == null || stops.length == 0) return null;

        Node head = new Node(stops[0]);
        Node curr = head;
        Node loopTarget = (pos == 0) ? head : null;

        for (int i = 1; i < stops.length; i++) {
            curr.next = new Node(stops[i]);
            curr = curr.next;
            if (i == pos) {
                loopTarget = curr;
            }
        }

        if (pos >= 0 && loopTarget != null) {
            curr.next = loopTarget;
        }

        return head;
    }
}
