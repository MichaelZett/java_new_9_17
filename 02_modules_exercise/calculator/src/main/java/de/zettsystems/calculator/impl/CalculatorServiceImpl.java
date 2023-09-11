package de.zettsystems.calculator.impl;

import de.zettsystems.calculator.api.CalculatorService;

public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public int substract(int x, int y) {
        return x - y;
    }
}
