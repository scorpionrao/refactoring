package chapter1.solution;

import java.util.Enumeration;

/** Form Template Method */
public abstract class Statement {

    String value(Customer customer) {

        Enumeration rentals = customer.getRentals().elements();
        String result = headerString(customer);
        while(rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += eachRental(each);
        }
        result += footerString(customer);
        return result;
    }

    abstract String headerString(Customer customer);
    abstract String eachRental(Rental rental);
    abstract String footerString(Customer customer);
}
