package chapter1.solution;

public class RentalResourceModel {

    Movie movie;
    int daysRented;
    int expectedFrequentRenterPoints;
    double expectedAmount;

    RentalResourceModel(Movie movie, int daysRented, int expectedFrequentRenterPoints, double expectedAmount) {
        this.movie = movie;
        this.daysRented = daysRented;
        this.expectedFrequentRenterPoints = expectedFrequentRenterPoints;
        this.expectedAmount = expectedAmount;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double getExpectedAmount() {
        return expectedAmount;
    }

    public int getExpectedFrequentRenterPoints() {
        return expectedFrequentRenterPoints;
    }
}
