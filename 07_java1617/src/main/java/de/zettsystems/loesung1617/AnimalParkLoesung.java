package de.zettsystems.loesung1617;

public class AnimalParkLoesung {
    public static void main(String[] args) {
        AnimalLoesung dog1 = new DogLoesung("Bob");

        if (dog1 instanceof DogLoesung d1) {
            play(d1);
        }

        AnimalLoesung dog2 = new DogLoesung("Bob");
        System.out.println("\nAre both equal? %s".formatted(dog1.equals(dog2)));
//        System.out.printf("\nAre both equal? %s%n", dog1.equals(dog2));
    }

    static void play(DogLoesung d) {
        System.out.println("Playing with Dog...");
        d.makeSound();
    }

    static void play(CatLoesung c) {
        System.out.println("Playing with Cat...");
        c.makeSound();
    }
}

class AnimalLoesung {
    void makeSound() {
        System.out.println("Generic sound");
    }
}

class CatLoesung extends AnimalLoesung {
    void makeSound() {
        System.out.println("Miau");
    }
}

class DogLoesung extends AnimalLoesung {
    private String name;

    DogLoesung(String name) {
        this.name = name;
    }

    void makeSound() {
        System.out.println("Au au");
    }

    public boolean equals(Object o) {
        return o instanceof DogLoesung d1 && d1.name.equals(name);
    }

}