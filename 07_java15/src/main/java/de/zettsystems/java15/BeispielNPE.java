package de.zettsystems.java15;

public class BeispielNPE {

    static class Person {
        Address address;
    }

    static class Address {
        String street;
    }

    /**
     * Fehlermeldung früher:
     * Exception in thread "main" java.lang.NullPointerException
     *     at BeispielNPE.main(BeispielNPE.java:20)
     */
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.address.street.length());
    }
}
