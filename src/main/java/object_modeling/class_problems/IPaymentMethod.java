package object_modeling.class_problems;

public interface IPaymentMethod {
    boolean processPayment(double amount);
    String getMethodName();
}
