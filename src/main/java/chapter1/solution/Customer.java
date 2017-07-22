package chapter1.solution;

import java.util.Enumeration;
import java.util.Vector;

class Customer {

    private String name;
    private Vector<Rental> rentals = new Vector<Rental>();

    Customer(String name, Vector<Rental> rentals) {
        this.name = name;
        this.rentals = rentals;
    }
/*
    void addRental(Rental arg) {
        rentals.add(arg);
    }
*/
    String getName() {
        return this.name;
    }

    public Vector<Rental> getRentals() {
        return rentals;
    }

    double getTotalCharge() {
        double result = 0;
        Enumeration rentals = this.rentals.elements();
        while(rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = this.rentals.elements();
        while(rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    String statement() {
        return new TextStatement().value(this);
    }

    String htmlStatement() {
        return new HtmlStatement().value(this);
    }
}