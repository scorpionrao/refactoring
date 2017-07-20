package chapter5.extractmethod;

/**
 * Created by rgonugunta on 7/18/17.
 */
public class Order {

    private double amount;
    Order(double amount) {
        this.amount = amount;
    }
    public double getAmount() {
        return this.amount;
    }
}
