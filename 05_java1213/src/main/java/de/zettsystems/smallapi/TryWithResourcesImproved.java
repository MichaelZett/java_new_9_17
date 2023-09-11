package de.zettsystems.smallapi;

import java.util.Scanner;

public class TryWithResourcesImproved {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // wenn die Variable "effectively final" ist, also im Ablauf nicht geändert wird, kann man
        // diese nun in try verwenden
        try (scanner) {
            System.out.println(scanner.nextLine());
        }
    }
}
