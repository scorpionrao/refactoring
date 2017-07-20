package chapter1.solution;

public abstract class Price {
    abstract int getPriceCode();

    protected abstract double getCharge(int daysRented);

    protected int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
