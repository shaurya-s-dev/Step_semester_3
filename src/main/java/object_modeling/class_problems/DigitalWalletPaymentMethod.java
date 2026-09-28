package object_modeling.class_problems;

public class DigitalWalletPaymentMethod implements IPaymentMethod {
    private boolean simulateSuccess;

    public DigitalWalletPaymentMethod(boolean simulateSuccess) {
        this.simulateSuccess = simulateSuccess;
    }

    @Override
    public boolean processPayment(double amount) {
        return simulateSuccess;
    }

    @Override
    public String getMethodName() {
        return "Digital Wallet";
    }
}
