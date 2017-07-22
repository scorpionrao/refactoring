package chapter7.replaceDataValueToObjectToReferenceObject;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Client {

    private static int numberOfOrdersFor(Collection<Order> orders, String customer) {
        int result = 0;
        Iterator iter = orders.iterator();
        while (iter.hasNext()) {
            Order each = (Order) iter.next();
            if(each.getCustomerName().equalsIgnoreCase(customer)) {
                result++;
            }
        }
        return result;
    }

    @BeforeClass
    public static void setUp() {
        Customer.loadCustomers();
    }

    @Test
    public void testSingleIncludedOrder() {
        final Order order = new Order("Ramanuja");
        Collection<Order> orders = Arrays.asList(order);
        Assert.assertTrue(1 == numberOfOrdersFor(orders, "Ramanuja"));

    }

    @Test
    public void testSingleExcludedOrder() {
        final Order order = new Order("Ramanuja");
        Collection<Order> orders = Arrays.asList(order);
        Assert.assertTrue(0 == numberOfOrdersFor(orders, "Ram"));

    }
}
