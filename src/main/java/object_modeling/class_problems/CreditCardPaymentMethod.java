package object_modeling.class_problems;

public class CreditCardPaymentMethod implements IPaymentMethod {
    private boolean simulateSuccess;

    public CreditCardPaymentMethod(boolean simulateSuccess) {
        this.simulateSuccess = simulateSuccess;
    }

    @Override
    public boolean processPayment(double amount) {
        return simulateSuccess;
    }

    @Override
    public String getMethodName() {
        return "Credit Card";
    }
}
