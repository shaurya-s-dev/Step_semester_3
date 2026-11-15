package linked_list.class_problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 1: Order Walkthrough with Nested Types
 *
 * TASK:
 * Design an Order class with a LineItem static nested class
 * (productName, quantity, unitPrice and double total()) and a Cursor member inner class
 * with hasNext(), next() and reset(). Use the cursor to print every line item and the order total,
 * and justify in one line each why LineItem is static nested and Cursor is a member inner class.
 */
public class Order {

    public static class LineItem {
        private String productName;
        private int quantity;
        private double unitPrice;

        public LineItem(String productName, int quantity, double unitPrice) {
            this.productName = productName;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        public String getProductName() {
            return productName;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public double total() {
            return quantity * unitPrice;
        }

        @Override
        public String toString() {
            // e.g. Pen 30
            long tot = Math.round(total());
            return productName + " " + tot;
        }
    }

    private List<LineItem> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(String productName, int quantity, double unitPrice) {
        items.add(new LineItem(productName, quantity, unitPrice));
    }

    public void addItem(LineItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double sum = 0;
        for (LineItem item : items) {
            sum += item.total();
        }
        return sum;
    }

    public Cursor getCursor() {
        return new Cursor();
    }

    public class Cursor {
        private int index = 0;

        public boolean hasNext() {
            return index < items.size();
        }

        public LineItem next() {
            if (!hasNext()) return null;
            return items.get(index++);
        }

        public void reset() {
            index = 0;
        }
    }

    public static void main(String[] args) {
        Order order = new Order();
        order.addItem("Pen", 3, 10);
        order.addItem("Book", 2, 250);
        order.addItem("Bag", 1, 700);

        Order.Cursor cursor = order.getCursor();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
        System.out.println("Total " + Math.round(order.calculateTotal()));
        System.out.println("cursor: inner (reads the order's array)");
        System.out.println("line item: static nested (needs no order)");
    }
}
