package object_modeling.assigment_problems;

public class StandardShipping implements ShippingType {

    @Override
    public String getTypeName() {
        return "Standard";
    }

    @Override
    public double calculateCharge(double weightKg) {
        return 40.0 + (10.0 * weightKg);
    }
}
