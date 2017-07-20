package chapter1.solution;

/**
 * Created by rgonugunta on 7/16/17.
 */
public class RegularPrice extends Price {
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    protected double getCharge(int daysRented) {
        double result = 2;
        if(daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }
}
