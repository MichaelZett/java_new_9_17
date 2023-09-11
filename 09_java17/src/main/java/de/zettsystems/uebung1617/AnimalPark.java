package de.zettsystems.uebung1617;

public class AnimalPark {
    public static void main(String[] args) {
        Animal dog1 = new Dog("Bob");

        // TODO use new Java api
        if (dog1 instanceof Dog) {
            Dog d1 = (Dog) dog1;
            play(d1);
        }

        Animal dog2 = new Dog("Bob");
        System.out.println("\nAre both equal? " + dog1.equals(dog2));
    }

    static void play(Dog d) {
        System.out.println("Playing with Dog...");
        d.makeSound();
    }

    static void play(Cat c) {
        System.out.println("Playing with Cat...");
        c.makeSound();
    }
}

class Animal {
    void makeSound() {
        System.out.println("Generic sound");
    }
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("Miau");
    }
}

class Dog extends Animal {
    private String name;

    Dog(String name) {
        this.name = name;
    }

    void makeSound() {
        System.out.println("Au au");
    }

    // TODO use new Java api
    public boolean equals(Object o) {
        // need to check if is the same type
        if (!(o instanceof Dog))
            return false;
        // then we cast to work with this type
        Dog d1 = (Dog) o;
        // only now we can performe our [business] logic to compare
        return d1.name.equals(name);
    }

}