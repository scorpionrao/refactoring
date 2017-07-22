package chapter7.unidirectionalassociaiontobidirectional;

public class Order {

    Customer customer;

    Customer getCustomer() {
        return customer;
    }

    void setCustomer(Customer arg) {
        if(customer != null) {
            customer.getOrders().remove(this);
        }
        this.customer = arg;
        if(customer != null) {
            customer.getOrders().add(this);
        }
    }
}
