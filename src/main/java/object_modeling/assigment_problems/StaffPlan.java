package object_modeling.assigment_problems;

public class StaffPlan implements PricingPlan {
    @Override
    public String getPlanName() { return "Staff"; }

    @Override
    public double applyDiscount(double price) { return price * 0.80; }
}
