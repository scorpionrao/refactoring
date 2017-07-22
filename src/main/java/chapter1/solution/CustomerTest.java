package chapter1.solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Vector;

public class CustomerTest {

    private static final String CUSTOMER_NAME = "Hari";

    private static final Movie MOVIE_NEW_RELEASE1 = new Movie("NR1", Movie.NEW_RELEASE);
    private static final Movie MOVIE_NEW_RELEASE2 = new Movie("NR2", Movie.NEW_RELEASE);
    private static final Movie MOVIE_REGULAR1 = new Movie("R1", Movie.REGULAR);
    private static final Movie MOVIE_REGULAR2 = new Movie("R2", Movie.REGULAR);
    private static final Movie MOVIE_CHILDRENS1 = new Movie("C1", Movie.CHILDRENS);
    private static final Movie MOVIE_CHILDRENS2 = new Movie("C2", Movie.CHILDRENS);

    private static final int ONE_DAY = 1;
    private static final int TWO_DAY = 2;
    private static final int THREE_DAY = 3;
    private static final int FOUR_DAY = 4;

    private static final int ONE_POINTS = 1;
    private static final int TWO_POINTS = 2;
    private static final int THREE_POINTS = 3;
    private static final int FOUR_POINTS = 4;

    @Test
    public void testNewReleaseOneDay() {
        RentalResourceModel model = new RentalResourceModel(MOVIE_NEW_RELEASE1, ONE_DAY, ONE_POINTS, 3.0);
        assertStatements(model);
    }

    @Test
    public void testNewReleaseMoreThanOneDay() {
        assertStatements(new RentalResourceModel(MOVIE_NEW_RELEASE1, TWO_DAY, TWO_POINTS, 6.0));
    }

    @Test
    public void testRegularOneDay() {
        assertStatements(new RentalResourceModel(MOVIE_REGULAR1, ONE_DAY, ONE_POINTS, 2.0));
    }

    @Test
    public void testRegularTwoDays() {
        assertStatements(new RentalResourceModel(MOVIE_REGULAR1, TWO_DAY, ONE_POINTS, 2.0));
    }

    @Test
    public void testRegularMoreThanTwoDays() {
        assertStatements(new RentalResourceModel(MOVIE_REGULAR1, THREE_DAY, ONE_POINTS, 3.5));
    }

    @Test
    public void testChildrenOneDay() {
        assertStatements(new RentalResourceModel(MOVIE_CHILDRENS1, ONE_DAY, ONE_POINTS, 1.5));
    }

    @Test
    public void testChildrenTwoDays() {
        assertStatements(new RentalResourceModel(MOVIE_CHILDRENS1, TWO_DAY, ONE_POINTS, 1.5));
    }

    @Test
    public void testChildrenThreeDays() {
        assertStatements(new RentalResourceModel(MOVIE_CHILDRENS1, THREE_DAY, ONE_POINTS, 1.5));
    }

    @Test
    public void testChildrenMoreThanThreeDays() {
        assertStatements(new RentalResourceModel(MOVIE_CHILDRENS1, FOUR_DAY, ONE_POINTS, 3.0));
    }

    @Test
    public void testNewReleaseOneDayRegularOneDay() {

        Rental[] rentals = new Rental[2];
        rentals[0] = new Rental(MOVIE_NEW_RELEASE1, ONE_DAY);
        rentals[1] = new Rental(MOVIE_REGULAR1, ONE_DAY);
        MovieAndAmount[] movieAndAmounts = {
                new MovieAndAmount(MOVIE_NEW_RELEASE1, 3.0),
                new MovieAndAmount(MOVIE_REGULAR1, 2.0)
        };
        Assert.assertEquals(getExpectedMessage(movieAndAmounts, 5.0, TWO_POINTS),
                getCustomerForMultipleRentals(rentals).statement());
        Assert.assertEquals(getExpectedHtmlMessage(movieAndAmounts, 5.0, TWO_POINTS),
                getCustomerForMultipleRentals(rentals).htmlStatement());
    }

    @Test
    public void testNewReleaseMoreThanOneDaysRegularMoreThanTwoDays() {

        Rental[] rentals = new Rental[2];
        rentals[0] = new Rental(MOVIE_NEW_RELEASE1, TWO_DAY);
        rentals[1] = new Rental(MOVIE_REGULAR1, THREE_DAY);
        Customer customer =
                getCustomerForMultipleRentals(rentals);
        MovieAndAmount[] movieAndAmounts = {
                new MovieAndAmount(MOVIE_NEW_RELEASE1, 6.0),
                new MovieAndAmount(MOVIE_REGULAR1, 3.5)
        };
        Assert.assertEquals(getExpectedMessage(movieAndAmounts, 9.5, THREE_POINTS), customer.statement());
        Assert.assertEquals(getExpectedHtmlMessage(movieAndAmounts, 9.5, THREE_POINTS), customer.htmlStatement());
    }

    @Test
    public void testNewReleaseOneDayChildrenOneDay() {

        Rental[] rentals = new Rental[2];
        rentals[0] = new Rental(MOVIE_NEW_RELEASE1, ONE_DAY);
        rentals[1] = new Rental(MOVIE_CHILDRENS1, ONE_DAY);
        Customer customer =
                getCustomerForMultipleRentals(rentals);
        MovieAndAmount[] movieAndAmounts = {
                new MovieAndAmount(MOVIE_NEW_RELEASE1, 3.0),
                new MovieAndAmount(MOVIE_CHILDRENS1, 1.5)
        };
        String expectedMessage = getExpectedMessage(movieAndAmounts, 4.5, TWO_POINTS);
        Assert.assertEquals(expectedMessage, customer.statement());
        String expectedHtmlMessage = getExpectedHtmlMessage(movieAndAmounts, 4.5, TWO_POINTS);
        Assert.assertEquals(expectedHtmlMessage, customer.htmlStatement());
    }

    @Test
    public void testNewReleaseMoreThanOneDaysChildrenMoreThanThreeDays() {

        Rental[] rentals = new Rental[2];
        rentals[0] = new Rental(MOVIE_NEW_RELEASE1, TWO_DAY);
        rentals[1] = new Rental(MOVIE_REGULAR1, FOUR_DAY);
        Customer customer =
                getCustomerForMultipleRentals(rentals);
        MovieAndAmount[] movieAndAmounts = {
                new MovieAndAmount(MOVIE_NEW_RELEASE1, 6.0),
                new MovieAndAmount(MOVIE_REGULAR1, 5.0)
        };
        String expectedMessage = getExpectedMessage(movieAndAmounts, 11.0, THREE_POINTS);
        Assert.assertEquals(expectedMessage, customer.statement());
        String expectedHtmlMessage = getExpectedHtmlMessage(movieAndAmounts, 11.0, THREE_POINTS);
        Assert.assertEquals(expectedHtmlMessage, customer.htmlStatement());
    }

    @Test
    public void testRegularOneDayChildrenOneDay() {

        Rental[] rentals = new Rental[2];
        rentals[0] = new Rental(MOVIE_REGULAR1, ONE_DAY);
        rentals[1] = new Rental(MOVIE_CHILDRENS1, ONE_DAY);
        Customer customer =
                getCustomerForMultipleRentals(rentals);
        MovieAndAmount[] movieAndAmounts = {
                new MovieAndAmount(MOVIE_REGULAR1, 2.0),
                new MovieAndAmount(MOVIE_CHILDRENS1, 1.5)
        };
        String expectedMessage = getExpectedMessage(movieAndAmounts, 3.5, TWO_POINTS);
        Assert.assertEquals(expectedMessage, customer.statement());
        String expectedHtmlMessage = getExpectedHtmlMessage(movieAndAmounts, 3.5, TWO_POINTS);
        Assert.assertEquals(expectedHtmlMessage, customer.htmlStatement());
    }

    @Test
    public void testRegularMoreThanTwoDaysChildrenMoreThanThreeDays() {

        Rental[] rentals = new Rental[2];
        rentals[0] = new Rental(MOVIE_REGULAR1, THREE_DAY);
        rentals[1] = new Rental(MOVIE_CHILDRENS1, FOUR_DAY);
        Customer customer =
                getCustomerForMultipleRentals(rentals);
        MovieAndAmount[] movieAndAmounts = {
                new MovieAndAmount(MOVIE_REGULAR1, 3.5),
                new MovieAndAmount(MOVIE_CHILDRENS1, 3.0)
        };
        String expectedMessage = getExpectedMessage(movieAndAmounts, 6.5, TWO_POINTS);
        Assert.assertEquals(expectedMessage, customer.statement());
        String expectedHtmlMessage = getExpectedHtmlMessage(movieAndAmounts, 6.5, TWO_POINTS);
        Assert.assertEquals(expectedHtmlMessage, customer.htmlStatement());
    }

    @Test
    public void testAllThreeOneDay() {

        Rental[] rentals = new Rental[3];
        rentals[0] = new Rental(MOVIE_NEW_RELEASE1, ONE_DAY);
        rentals[1] = new Rental(MOVIE_REGULAR1, ONE_DAY);
        rentals[2] = new Rental(MOVIE_CHILDRENS1, ONE_DAY);
        Customer customer =
                getCustomerForMultipleRentals(rentals);
        MovieAndAmount[] movieAndAmounts = {
                new MovieAndAmount(MOVIE_NEW_RELEASE1, 3.0),
                new MovieAndAmount(MOVIE_REGULAR1, 2.0),
                new MovieAndAmount(MOVIE_CHILDRENS1, 1.5)
        };
        String expectedMessage = getExpectedMessage(movieAndAmounts, 6.5, THREE_POINTS);
        Assert.assertEquals(expectedMessage, customer.statement());
        String expectedHtmlMessage = getExpectedHtmlMessage(movieAndAmounts, 6.5, THREE_POINTS);
        Assert.assertEquals(expectedHtmlMessage, customer.htmlStatement());
    }

    @Test
    public void testNewReleaseMoreThanOneDayRegularMoreThanTwoDaysChildrenMoreThanThreeDays() {

        Rental[] rentals = new Rental[3];
        rentals[0] = new Rental(MOVIE_NEW_RELEASE1, TWO_DAY);
        rentals[1] = new Rental(MOVIE_REGULAR1, THREE_DAY);
        rentals[2] = new Rental(MOVIE_CHILDRENS1, FOUR_DAY);
        Customer customer =
                getCustomerForMultipleRentals(rentals);
        MovieAndAmount[] movieAndAmounts = {
                new MovieAndAmount(MOVIE_NEW_RELEASE1, 6.0),
                new MovieAndAmount(MOVIE_REGULAR1, 3.5),
                new MovieAndAmount(MOVIE_CHILDRENS1, 3.0)
        };
        String expectedMessage = getExpectedMessage(movieAndAmounts, 12.5, FOUR_POINTS);
        Assert.assertEquals(expectedMessage, customer.statement());
        String expectedHtmlMessage = getExpectedHtmlMessage(movieAndAmounts, 12.5, FOUR_POINTS);
        Assert.assertEquals(expectedHtmlMessage, customer.htmlStatement());
    }

    @Test
    public void testTwoNewRelease() {

        Rental[] rentals = new Rental[2];
        rentals[0] = new Rental(MOVIE_NEW_RELEASE1, ONE_DAY);
        rentals[1] = new Rental(MOVIE_NEW_RELEASE2, TWO_DAY);
        Customer customer =
                getCustomerForMultipleRentals(rentals);
        MovieAndAmount[] movieAndAmounts = {
                new MovieAndAmount(MOVIE_NEW_RELEASE1, 3.0),
                new MovieAndAmount(MOVIE_NEW_RELEASE2, 6.0)
        };
        String expectedMessage = getExpectedMessage(movieAndAmounts, 9.0, THREE_POINTS);
        Assert.assertEquals(expectedMessage, customer.statement());
        String expectedHtmlMessage = getExpectedHtmlMessage(movieAndAmounts, 9.0, THREE_POINTS);
        Assert.assertEquals(expectedHtmlMessage, customer.htmlStatement());
    }

    @Test
    public void testTwoRegular() {

        Rental[] rentals = new Rental[2];
        rentals[0] = new Rental(MOVIE_REGULAR1, ONE_DAY);
        rentals[1] = new Rental(MOVIE_REGULAR2, THREE_DAY);
        Customer customer =
                getCustomerForMultipleRentals(rentals);
        MovieAndAmount[] movieAndAmounts = {
                new MovieAndAmount(MOVIE_REGULAR1, 2.0),
                new MovieAndAmount(MOVIE_REGULAR2, 3.5)
        };
        String expectedMessage = getExpectedMessage(movieAndAmounts, 5.5, TWO_POINTS);
        Assert.assertEquals(expectedMessage, customer.statement());
        String expectedHtmlMessage = getExpectedHtmlMessage(movieAndAmounts, 5.5, TWO_POINTS);
        Assert.assertEquals(expectedHtmlMessage, customer.htmlStatement());
    }

    @Test
    public void testTwoChildrens() {

        Rental[] rentals = new Rental[2];
        rentals[0] = new Rental(MOVIE_CHILDRENS1, ONE_DAY);
        rentals[1] = new Rental(MOVIE_CHILDRENS2, FOUR_DAY);
        Customer customer =
                getCustomerForMultipleRentals(rentals);
        MovieAndAmount[] movieAndAmounts = {
                new MovieAndAmount(MOVIE_CHILDRENS1, 1.5),
                new MovieAndAmount(MOVIE_CHILDRENS2, 3.0)
        };
        String expectedMessage = getExpectedMessage(movieAndAmounts, 4.5, TWO_POINTS);
        Assert.assertEquals(expectedMessage, customer.statement());
        String expectedHtmlMessage = getExpectedHtmlMessage(movieAndAmounts, 4.5, TWO_POINTS);
        Assert.assertEquals(expectedHtmlMessage, customer.htmlStatement());
    }

    private Customer getCustomerForOneRental(RentalResourceModel model) {
        Rental rental = new Rental(model.getMovie(), model.getDaysRented());
        Rental[] rentalArray = {rental};
        Vector<Rental> rentals = new Vector<Rental>(Arrays.asList(rentalArray));
        return new Customer(CUSTOMER_NAME, rentals);

    }

    private Customer getCustomerForMultipleRentals(Rental[] rentalArray) {
        Vector<Rental> rentals = new Vector<Rental>(Arrays.asList(rentalArray));
        return new Customer(CUSTOMER_NAME, rentals);

    }

    private String getExpectedMessage(RentalResourceModel model) {
        return "Rental Record for " + CUSTOMER_NAME + "\n" +
                "\t" + model.getMovie().getTitle() + "\t" + model.getExpectedAmount() + "\n" +
                "Amount owed is " + model.getExpectedAmount() + "\n" +
                "You earned " + model.getExpectedFrequentRenterPoints() + " frequent renter points";
    }

    private String getExpectedHtmlMessage(RentalResourceModel model) {
        return "<h1>Rental Record for <em>" + CUSTOMER_NAME + "</em></h1>\n" +
                "\t" + model.getMovie().getTitle() + "\t" + model.getExpectedAmount() + "<br>\n" +
                "<p>You owe <em>" + model.getExpectedAmount() + "</em></p>\n" +
                "<p>You earned <em>" + model.getExpectedFrequentRenterPoints() + "</em> frequent renter points</p>";
    }

    private String getExpectedMessage(MovieAndAmount[] movieAndAmounts, double amount, int frequentRenterPoints) {
        String result = "Rental Record for " + CUSTOMER_NAME + "\n";
        for(MovieAndAmount movieAndAmount : movieAndAmounts) {
            result += "\t" + movieAndAmount.getMovie().getTitle() + "\t" + movieAndAmount.getAmount() + "\n";
        }
        result += "Amount owed is " + amount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }

    private String getExpectedHtmlMessage(MovieAndAmount[] movieAndAmounts, double amount, int frequentRenterPoints) {
        String result = "<h1>Rental Record for <em>" + CUSTOMER_NAME + "</em></h1>\n";
        for(MovieAndAmount movieAndAmount : movieAndAmounts) {
            result += "\t" + movieAndAmount.getMovie().getTitle() + "\t" + movieAndAmount.getAmount() + "<br>\n";
        }
        result += "<p>You owe <em>" + amount + "</em></p>\n";
        result += "<p>You earned <em>" + frequentRenterPoints + "</em> frequent renter points</p>";
        return result;
    }

    private void assertStatements(RentalResourceModel model) {
        Assert.assertEquals(getExpectedMessage(model), getCustomerForOneRental(model).statement());
        Assert.assertEquals(getExpectedHtmlMessage(model), getCustomerForOneRental(model).htmlStatement());
    }

    class MovieAndAmount {
        private Movie movie;
        private double amount;
        MovieAndAmount(Movie movie, double amount) {
            this.movie = movie;
            this.amount = amount;
        }
        Movie getMovie() {
            return movie;
        }

        double getAmount() {
            return amount;
        }
    }

}
