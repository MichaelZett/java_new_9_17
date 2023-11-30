package de.zettsystems.user;

import de.zettsystems.calculator.api.CalculatorService;

import java.util.ServiceLoader;

public class User {
    public static void main(String[] args) {
        ServiceLoader<CalculatorService> calculators = ServiceLoader.load(CalculatorService.class);
        CalculatorService calculator = calculators.findFirst().orElseThrow();

        System.out.println("Addition von 5 und 7: " + calculator.add(5,7));
        System.out.println("Subtraktion von 12 und 7: " + calculator.substract(12,7));
    }
}
