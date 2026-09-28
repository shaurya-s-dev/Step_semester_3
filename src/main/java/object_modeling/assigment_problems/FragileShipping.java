package object_modeling.assigment_problems;

public class FragileShipping implements ShippingType {
    private StandardShipping standardShipping = new StandardShipping();

    @Override
    public String getTypeName() {
        return "Fragile";
    }

    @Override
    public double calculateCharge(double weightKg) {
        return standardShipping.calculateCharge(weightKg) + 50.0;
    }
}
