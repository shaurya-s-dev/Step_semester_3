package object_modeling.assigment_problems;

public interface ShippingType {
    String getTypeName();
    double calculateCharge(double weightKg);
}
