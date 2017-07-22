package chapter7.unidirectionalassociaiontobidirectional;

import java.util.HashSet;
import java.util.Set;

public class Customer {

    private Set _orders = new HashSet();

    /** Should only be used by Order class when modifying the association */

    /** Order is being given charge of this association - tell 1 to many */
    Set getOrders() {
        return _orders;
    }

    void addOrder(Order arg) {
        arg.setCustomer(this);
    }
}
