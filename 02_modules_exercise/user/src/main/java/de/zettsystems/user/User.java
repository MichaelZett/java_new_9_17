package de.zettsystems.user;


import de.zettsystems.calculator.api.CalculatorService;
import de.zettsystems.calculator.impl.CalculatorServiceImpl;

public class User {
    public static void main(String[] args) {
        CalculatorService calculator = new CalculatorServiceImpl();

        System.out.println("Addition von 5 und 7: " + calculator.add(5,7));
        System.out.println("Substraktion von 12 und 7: " + calculator.substract(12,7));
    }
}
