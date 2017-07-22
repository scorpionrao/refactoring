package chapter1.solution;

public class TextStatement extends Statement {

    String eachRental(Rental each) {
        return "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
    }

    String footerString(Customer customer) {
        return "Amount owed is " + String.valueOf(customer.getTotalCharge()) + "\n"
            + "You earned " + String.valueOf(customer.getTotalFrequentRenterPoints()) + " frequent renter points";
    }

    String headerString(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }

}
