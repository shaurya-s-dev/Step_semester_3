package object_modeling.assigment_problems;

public class HostellerPlan implements PricingPlan {
    @Override
    public String getPlanName() { return "Hosteller"; }

    @Override
    public double applyDiscount(double price) { return price * 0.90; }
}
