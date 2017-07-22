package chapter7.replaceDataValueToObjectToReferenceObject;

import java.util.Dictionary;
import java.util.Hashtable;

public class Customer {

    /*
    Order is access point for line items
    Registry is access point for customers
    There is no such registry object, hence creating below access point
     */
    private static Dictionary<String, Customer> _customersAccessPoint = new Hashtable();

    static void loadCustomers() {
        new Customer("Lemon Car Hire").storeIntoRegistry();
        new Customer("Associated Coffee Machines").storeIntoRegistry();
        new Customer("Bilston Gasworks").storeIntoRegistry();
        new Customer("Ramanuja").storeIntoRegistry();
    }

    void storeIntoRegistry() {
        _customersAccessPoint.put(this.getName(), this);
    }

    private String _name;
    private Customer(String name) {
        _name = name;
    }
    public String getName() {
        return _name;
    }

    /*
    This controls - registry is immutable, reference object is immutable
     */
    public static Customer getReferenceObjectFromFactory(String name) {
        return _customersAccessPoint.get(name);
    }
}
