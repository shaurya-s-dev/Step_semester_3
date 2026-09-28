package object_modeling.assigment_problems;

public class ExpressShipping implements ShippingType {

    @Override
    public String getTypeName() {
        return "Express";
    }

    @Override
    public double calculateCharge(double weightKg) {
        return 80.0 + (15.0 * weightKg);
    }
}
