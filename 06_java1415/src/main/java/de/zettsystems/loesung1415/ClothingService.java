package de.zettsystems.loesung1415;

public final class ClothingService {
    private ClothingService() {
        // not intended
    }

    public static String decideCloths(Season season) {
        return switch (season) {
            case SPRING, AUTUMN -> "PULLOVER";
            case SUMMER -> "T-SHIRT";
            case WINTER -> "JACKET";
        };
    }
}
