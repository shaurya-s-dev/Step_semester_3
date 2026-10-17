package linked_list.assigment_problems;

/**
 * Problem 6: Campus Portal Browser History
 *
 * TASK:
 * A campus portal browser opens on a home page and supports three actions:
 * - visit a new page (which clears all forward history)
 * - go back up to x pages
 * - go forward up to x pages
 * Back and forward stop at the first and last pages available.
 *
 * Design a BrowserHistory class backed by your own doubly linked list, with visit(url),
 * back(steps), and forward(steps); back and forward return the current page.
 *
 * CONSTRAINTS:
 * - 1 <= number of actions <= 5000
 * - 1 <= steps <= 100
 * - Each visit is O(1); back and forward are O(steps)
 *
 * COMPLEXITY:
 * - visit(url): O(1) time. A new node is allocated and linked to curr.next.
 * - back(steps): O(min(steps, length_of_backward_history)) time. Traverses backward node-by-node.
 * - forward(steps): O(min(steps, length_of_forward_history)) time. Traverses forward node-by-node.
 * - Auxiliary Space: O(N) total across all visited pages that remain reachable.
 * - Discarding Forward History:
 *   When `visit(url)` is invoked, `curr.next` is overwritten with the new node reference, and the
 *   new node's `prev` points to `curr`. The forward nodes previously reachable from `curr.next`
 *   are detached from the live list. In Java, because these detached nodes are no longer reachable
 *   from any active GC roots, the garbage collector automatically reclaims their memory.
 */
public class BrowserHistory {

    public static class Node {
        public String url;
        public Node prev;
        public Node next;

        public Node(String url) {
            this.url = url;
            this.prev = null;
            this.next = null;
        }
    }

    private Node curr;

    /**
     * Initializes the browser history with the homepage.
     *
     * @param homepage the starting URL
     */
    public BrowserHistory(String homepage) {
        this.curr = new Node(homepage);
    }

    /**
     * Visits a new URL from the current page, clearing all forward history.
     *
     * @param url the URL to visit
     */
    public void visit(String url) {
        Node newNode = new Node(url);
        curr.next = newNode;
        newNode.prev = curr;
        curr = newNode;
    }

    /**
     * Moves back in history up to steps pages.
     *
     * @param steps number of steps to move back
     * @return current page URL after moving back
     */
    public String back(int steps) {
        while (steps > 0 && curr.prev != null) {
            curr = curr.prev;
            steps--;
        }
        return curr.url;
    }

    /**
     * Moves forward in history up to steps pages.
     *
     * @param steps number of steps to move forward
     * @return current page URL after moving forward
     */
    public String forward(int steps) {
        while (steps > 0 && curr.next != null) {
            curr = curr.next;
            steps--;
        }
        return curr.url;
    }

    public String getCurrentUrl() {
        return curr != null ? curr.url : "";
    }
}
