package object_modeling.assigment_problems;

import java.util.ArrayList;
import java.util.List;

public class SmartCard {
    public enum CardState { ACTIVE, BLOCKED }

    private String cardId;
    private String holderName;
    private double balance;
    private PricingPlan plan;
    private CardState state;
    private List<String> transactions;
    private boolean refundUsed;

    public SmartCard(String cardId, String holderName, PricingPlan plan) {
        this.cardId = cardId;
        this.holderName = holderName;
        this.plan = plan;
        this.balance = 0.0;
        this.state = CardState.ACTIVE;
        this.transactions = new ArrayList<>();
        this.refundUsed = false;
    }

    public String getCardId() { return cardId; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
    public CardState getState() { return state; }
    public PricingPlan getPlan() { return plan; }

    public String topUp(double amount) {
        if (state == CardState.BLOCKED) {
            return "Top-up failed: Card " + cardId + " is blocked.";
        }
        if (amount < 100 || amount > 5000) {
            return String.format("Top-up failed: Amount must be between ₹100 and ₹5000.");
        }
        this.balance += amount;
        transactions.add("TOP-UP ₹" + amount);
        return String.format("Top-up successful: ₹%.2f added. New balance: ₹%.2f.", amount, balance);
    }

    public String purchase(double itemPrice, String itemRef) {
        if (state == CardState.BLOCKED) {
            return "Purchase failed: Card " + cardId + " is blocked.";
        }
        double finalPrice = plan.applyDiscount(itemPrice);
        if (balance < finalPrice) {
            return String.format("Purchase failed: Insufficient balance (Balance: ₹%.2f, Required: ₹%.2f).", balance, finalPrice);
        }
        this.balance -= finalPrice;
        transactions.add("PURCHASE ₹" + finalPrice + " - " + itemRef);
        return String.format("Purchased '%s' for ₹%.2f (%s discount). New balance: ₹%.2f.",
                itemRef, finalPrice, plan.getPlanName(), balance);
    }

    public String refund(double amount, String ref) {
        if (refundUsed) {
            return "Refund failed: One-time refund already used for card " + cardId + ".";
        }
        if (state == CardState.BLOCKED) {
            return "Refund failed: Card " + cardId + " is blocked.";
        }
        this.balance += amount;
        this.refundUsed = true;
        transactions.add("REFUND ₹" + amount + " - " + ref);
        return String.format("Refund of ₹%.2f processed for '%s'. New balance: ₹%.2f.", amount, ref, balance);
    }

    public String blockCard() {
        this.state = CardState.BLOCKED;
        return "Card " + cardId + " blocked successfully.";
    }

    public List<String> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public String getSummary() {
        return String.format("Card: %s | Holder: %s | Balance: ₹%.2f | Plan: %s | State: %s",
                cardId, holderName, balance, plan.getPlanName(), state);
    }
}
