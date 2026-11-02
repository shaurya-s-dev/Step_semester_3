package linked_list.assigment_problems;

/**
 * Problem 4: The Bus Bay Ring
 *
 * TASK:
 * Design a BusBay(int capacity) backed by a fixed-size int array used as a ring buffer (circular deque).
 * Methods:
 * - insertFront(bus)
 * - insertLast(bus)
 * - deleteFront()
 * - deleteLast()
 * - getFront()
 * - getRear()
 * - isEmpty()
 * - isFull()
 * All methods run in O(1) time without shifting or collections.
 */
public class BusBay {
    private int[] buffer;
    private int capacity;
    private int front;
    private int size;

    public BusBay(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.front = 0;
        this.size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean insertFront(int bus) {
        if (isFull()) return false;
        front = (front - 1 + capacity) % capacity;
        buffer[front] = bus;
        size++;
        return true;
    }

    public boolean insertLast(int bus) {
        if (isFull()) return false;
        int rearIndex = (front + size) % capacity;
        buffer[rearIndex] = bus;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return buffer[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        int rearIndex = (front + size - 1) % capacity;
        return buffer[rearIndex];
    }
}
