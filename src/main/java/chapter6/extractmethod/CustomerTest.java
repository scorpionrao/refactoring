package chapter6.extractmethod;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Vector;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by rgonugunta on 7/18/17.
 */
public class CustomerTest {


    @Test
    public void testNoOrder() {

        Customer customer = new Customer("test", new Vector<Order>());
        Assert.assertThat(0.0, equalTo(customer.printOwing(0)));
    }

    @Test
    public void testOneOrderZeroValue() {
        Order order = new Order(0.0);
        Order[] orders = {order};
        Vector<Order> ordersVector = new Vector<Order>(Arrays.asList(orders));
        Customer customer = new Customer("test", ordersVector);
        Assert.assertThat(0.0, equalTo(customer.printOwing(0)));
    }

    @Test
    public void testOneOrderSomeValue() {
        Order order = new Order(5.0);
        Order[] orders = {order};
        Vector<Order> ordersVector = new Vector<Order>(Arrays.asList(orders));
        Customer customer = new Customer("test", ordersVector);
        Assert.assertThat(5.0, equalTo(customer.printOwing(0)));
    }

    @Test
    public void testMultipleOrders() {
        Order order1 = new Order(5.0);
        Order order2 = new Order(5.0);
        Order[] orders = {order1, order2};
        Vector<Order> ordersVector = new Vector<Order>(Arrays.asList(orders));
        Customer customer = new Customer("test", ordersVector);
        Assert.assertThat(10.0, equalTo(customer.printOwing(0)));
    }
}
