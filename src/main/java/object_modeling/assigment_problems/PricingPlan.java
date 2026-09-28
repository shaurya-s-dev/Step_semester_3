package object_modeling.assigment_problems;

public interface PricingPlan {
    String getPlanName();
    double applyDiscount(double price);
}
