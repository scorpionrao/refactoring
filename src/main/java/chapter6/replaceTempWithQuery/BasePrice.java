package chapter6.replaceTempWithQuery;

public class BasePrice {

    int quantity;
    double itemPrice;

    public BasePrice(int quantity, double itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public double getBasePrice() {
        return basePrice() * discountFactor();
    }

    public double discountFactor() {
        return (basePrice() > 1000.0) ? 0.98 : 0.95;
    }

    public double basePrice() {
        return quantity * itemPrice;
    }
}
