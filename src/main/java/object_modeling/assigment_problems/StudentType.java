package object_modeling.assigment_problems;

public enum StudentType {
    REGULAR(24),
    HONORS(28),
    EXCHANGE(20);

    private final int creditLimit;

    StudentType(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public int getCreditLimit() {
        return creditLimit;
    }
}
