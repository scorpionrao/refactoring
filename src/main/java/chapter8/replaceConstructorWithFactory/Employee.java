package chapter8.replaceConstructorWithFactory;

public class Employee {

    private int type;

    static final int ENGINEER = 0;
    static final int SALESMAN = 1;
    static final int MANAGER = 2;

    /** avoids updating this method when a new sub class is created, but no compile time checking */
    static Employee create(String name) {
        try {
            return (Employee) Class.forName(name).newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to instantiate - " + name);
        }
    }

    // This leads to super class knowing sub class
    static Employee createEngineer() {
        return new Engineer();
    }

}
