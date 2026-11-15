package linked_list.assigment_problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 3: Recent Pages Cache
 *
 * TASK:
 * Implement RecentCache(int capacity) with:
 * - String get(int key) in O(1)
 * - void put(int key, String page) in O(1)
 * Uses custom doubly linked list with dummy head and tail and a HashMap from key to node.
 */
public class RecentCache {

    public static class Node {
        public int key;
        public String val;
        public Node prev;
        public Node next;

        public Node(int key, String val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public RecentCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, "");
        this.tail = new Node(-1, "");
        head.next = tail;
        tail.prev = head;
    }

    private void addFirst(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToFront(Node node) {
        removeNode(node);
        addFirst(node);
    }

    public String get(int key) {
        if (!map.containsKey(key)) {
            return "-1";
        }
        Node node = map.get(key);
        moveToFront(node);
        return node.val;
    }

    public String put(int key, String page) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = page;
            moveToFront(node);
            return "put(" + key + "," + page + ") updated";
        } else {
            String evictedMsg = "";
            if (map.size() >= capacity) {
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
                evictedMsg = " evicted " + lru.key;
            }
            Node newNode = new Node(key, page);
            map.put(key, newNode);
            addFirst(newNode);
            return "put(" + key + "," + page + ")" + evictedMsg;
        }
    }

    public String getCacheState() {
        StringBuilder sb = new StringBuilder("Cache (most recent first): ");
        Node curr = head.next;
        boolean first = true;
        while (curr != tail) {
            if (!first) sb.append(", ");
            sb.append(curr.key).append("=").append(curr.val);
            first = false;
            curr = curr.next;
        }
        return sb.toString();
    }
}
