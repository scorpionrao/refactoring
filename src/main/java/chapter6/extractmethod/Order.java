package chapter6.extractmethod;

public class Order {

    private double amount;
    Order(double amount) {
        this.amount = amount;
    }
    public double getAmount() {
        return this.amount;
    }
}
