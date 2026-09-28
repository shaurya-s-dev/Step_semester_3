package object_modeling.class_problems;

import java.util.ArrayList;
import java.util.List;

public class FoodOrder {
    private static int orderCounter = 122;

    private int orderId;
    private OrderCustomer customer;
    private List<LineItem> items;
    private OrderStatus status;

    public FoodOrder(OrderCustomer customer) {
        this.orderId = ++orderCounter;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.status = OrderStatus.CREATED;
    }

    public int getOrderId() {
        return orderId;
    }

    public OrderCustomer getCustomer() {
        return customer;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void addItem(FoodItem item, int quantity) {
        items.add(new LineItem(item, quantity));
    }

    public List<LineItem> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (LineItem li : items) {
            total += li.getSubtotal();
        }
        return total;
    }

    public String placeOrder(IPaymentMethod paymentMethod) {
        if (items.isEmpty()) {
            return "Cannot place order: Order must contain at least one item.";
        }

        double total = calculateTotal();
        boolean paymentSuccess = paymentMethod.processPayment(total);

        if (paymentSuccess) {
            this.status = OrderStatus.PAID;
            return String.format("Order placed successfully. Payment via %s successful. Order status: %s. Notification: Order #%d placed and paid.",
                    paymentMethod.getMethodName(), status.getDisplay(), orderId);
        } else {
            this.status = OrderStatus.PENDING_PAYMENT;
            return String.format("Order placed. Payment via %s failed. Order status: %s. Notification: Order #%d placed, awaiting payment.",
                    paymentMethod.getMethodName(), status.getDisplay(), orderId);
        }
    }
}
