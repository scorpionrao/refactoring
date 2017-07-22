package chapter7.replaceDataValueToObjectToReferenceObject;

public class Order {

    private Customer _customer;

    Order(String customerName) {
        this._customer = Customer.getReferenceObjectFromFactory(customerName);
    }

    public String getCustomerName() {
        return _customer.getName();
    }

    public void setCustomer(String customerName) {
        this._customer = Customer.getReferenceObjectFromFactory(customerName);
    }
}
