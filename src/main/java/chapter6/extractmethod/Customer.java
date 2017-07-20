package chapter6.extractmethod;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector<Order> orders = new Vector<Order>();

    Customer(String name, Vector<Order> orders) {
        this.name = name;
        this.orders = orders;
    }

    double printOwing(double previousAmount) {
        printBanner();
        double outstanding = getOutstanding(previousAmount * 1.2);
        printDetails(outstanding);
        return outstanding;
    }

    private double getOutstanding(double initialValue) {
        Enumeration e = this.orders.elements();
        double result = initialValue;
        while(e.hasMoreElements()) {
            Order each = (Order) e.nextElement();
            result += each.getAmount();
        }
        return result;
    }

    // local variable is only read
    private void printDetails(double outstanding) {
        System.out.println("name:" + name);
        System.out.println("amount" + outstanding);
    }

    // no parameters - simple extract
    private void printBanner() {
        System.out.println("***************************");
        System.out.println("****** Customer Owes ******");
        System.out.println("***************************");
    }

}
