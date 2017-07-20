package chapter6.replaceTempWithQuery;

/**
 * Created by rgonugunta on 7/19/17.
 */
public class Sample {

    int quantity;
    double itemPrice;

    public Sample(int quantity, double itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public double getBasePrice() {
        if(basePrice() > 1000.0) {
            return basePrice() * 0.98;
        } else {
            return basePrice() * 0.95;
        }
    }

    public double basePrice() {
        return quantity * itemPrice;
    }
}
