module de.zettsystems.calculatorimpl {
    requires de.zettsystems.calculator;

    provides de.zettsystems.calculator.api.CalculatorService with de.zettsystems.calculator.impl.CalculatorServiceImpl;
}