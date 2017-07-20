package chapter1.solution;

public class Rental {

    Movie movie;
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

    protected double getCharge() {
        return movie.getCharge(daysRented);
    }

    protected int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }

}