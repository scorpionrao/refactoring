package chapter1.solution;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    protected Movie getMovie() {
        return movie;
    }

    private int getDaysRented() {
        return daysRented;
    }

    double getCharge() {
        double result = 0;
        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if(daysRented > 2) {
                    result += (daysRented - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if(daysRented > 3) {
                    result += (daysRented - 3) * 1.5;
                }
        }
        return result;
    }

    int getFrequentRenterPoints() {
        // add bonus for a two day new release rental
        if((Movie.NEW_RELEASE == movie.getPriceCode()) && daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}