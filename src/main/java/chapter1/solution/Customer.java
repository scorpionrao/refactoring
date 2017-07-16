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
    private String getName() {
        return this.name;
    }

    String statement() {

        Enumeration rentals = this.rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while(rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    String htmlStatement() {

        Enumeration rentals = this.rentals.elements();
        String result = "<h1>Rental Record for <em>" + getName() + "</em></h1>\n";
        while(rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "<br>\n";
        }

        // add footer lines
        result += "<p>You owe <em>" + String.valueOf(getTotalCharge()) + "</em></p>\n";
        result += "<p>You earned <em>" + String.valueOf(getTotalFrequentRenterPoints()) +
                "</em> frequent renter points</p>";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = this.rentals.elements();
        while(rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = this.rentals.elements();
        while(rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

}