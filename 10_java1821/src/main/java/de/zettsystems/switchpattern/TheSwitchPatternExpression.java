package de.zettsystems.switchpattern;

public class TheSwitchPatternExpression {
    public static void main(String[] args) {
        System.out.println(getDoubleUsingIf(3));
        System.out.println(getDoubleUsingSwitch(5));
        System.out.println(getDoubleValueUsingGuardedPatterns("7.0"));
        System.out.println(getDoubleValueUsingParenthesizedPatterns(9));
    }

    /**
     * früher ging Folgendes mit Switch gar nicht - daher mit if
     */
    static double getDoubleUsingIf(Object o) {
        double result;
        if (o instanceof Integer) {
            result = ((Integer) o).doubleValue();
        } else if (o instanceof Float) {
            result = ((Float) o).doubleValue();
        } else if (o instanceof String) {
            result = Double.parseDouble(((String) o));
        } else {
            result = 0d;
        }
        return result;
    }

    static double getDoubleUsingSwitch(Object o) {
        return switch (o) {
            case Integer i -> i.doubleValue();
            case Float f -> f.doubleValue();
            case String s -> Double.parseDouble(s);
            default -> 0d;
        };
    }

    static double getDoubleValueUsingGuardedPatterns(Object o) {
        return switch (o) {
            case Integer i -> i.doubleValue();
            case Float f -> f.doubleValue();
            case String s && !s.isEmpty() -> Double.parseDouble(s);
            default -> 0d;
        };
    }

    // In Java 21 hat sich ein wenig geändert. Weitere Bedingungen müssen nun mit 'when' eingeleitet werden.
    // Es gibt die Möglichkeit des null-Labels.
//    static double getDoubleValueUsingGuardedPatterns(Object o) {
//        return switch (o) {
//            case null -> -1d;
//            case Integer i -> i.doubleValue();
//            case Float f -> f.doubleValue();
//            case String s when !s.isEmpty() -> Double.parseDouble(s);
//            default -> 0d;
//        };
//    }
//
//    static double getDoubleValueUsingParenthesizedPatterns(Object o) {
//        return switch (o) {
//            case null -> -1d;
//            case Integer i -> i.doubleValue();
//            case Float f -> f.doubleValue();
//            case String s when !s.isEmpty() && !(s.contains("#") || s.contains("@")) -> Double.parseDouble(s);
//            default -> 0d;
//        };
//    }

    static double getDoubleValueUsingParenthesizedPatterns(Object o) {
        return switch (o) {
            case Integer i -> i.doubleValue();
            case Float f -> f.doubleValue();
            case String s && !s.isEmpty() && !(s.contains("#") || s.contains("@")) -> Double.parseDouble(s);
            default -> 0d;
        };
    }
}
