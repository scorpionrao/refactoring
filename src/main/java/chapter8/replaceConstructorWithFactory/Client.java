package chapter8.replaceConstructorWithFactory;

public class Client {
    public static void main(String[] args) {
        // exposes sub class name to clients
        Employee employee = Employee.create("Engineer");

        Employee employee1 = Employee.createEngineer();
    }
}
