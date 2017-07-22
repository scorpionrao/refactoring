package chapter6.removeAssignmentsToParameters;

public class Param {

    private static void triple(int arg) {
        arg = arg * 3;
        System.out.println("Inside Triple method : arg after triple = " + arg);
    }

    public static void main(String[] args) {
        int arg = 5;
        triple(arg);
        System.out.println("Inside Main method : arg after triple = " + arg);
    }
}
