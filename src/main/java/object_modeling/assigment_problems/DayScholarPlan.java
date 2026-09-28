package object_modeling.assigment_problems;

public class DayScholarPlan implements PricingPlan {
    @Override
    public String getPlanName() { return "Day Scholar"; }

    @Override
    public double applyDiscount(double price) { return price; }
}
