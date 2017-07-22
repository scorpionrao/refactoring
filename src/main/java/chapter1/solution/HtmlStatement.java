package chapter1.solution;

public class HtmlStatement extends Statement {

    String eachRental(Rental each) {
        return "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "<br>\n";
    }

    String footerString(Customer customer) {
        return "<p>You owe <em>" + String.valueOf(customer.getTotalCharge()) + "</em></p>\n"
            + "<p>You earned <em>" + String.valueOf(customer.getTotalFrequentRenterPoints()) +
                "</em> frequent renter points</p>";
    }

    String headerString(Customer customer) {
        return "<h1>Rental Record for <em>" + customer.getName() + "</em></h1>\n";
    }

}
