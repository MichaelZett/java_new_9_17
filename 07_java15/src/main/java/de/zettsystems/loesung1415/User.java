package de.zettsystems.loesung1415;

public class User {
    public static void main(String[] args) {
        System.out.println("Im Sommer tragen wir: %s".formatted(ClothingService.decideCloths(Season.SUMMER)));
        System.out.printf("Im Sommer tragen wir: %s%n", ClothingService.decideCloths(Season.SUMMER));
    }
}
