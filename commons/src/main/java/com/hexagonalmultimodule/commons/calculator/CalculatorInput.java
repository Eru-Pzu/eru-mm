package com.hexagonalmultimodule.commons.calculator;

import java.util.List;

public interface CalculatorInput {
    CustomerCalculationInput getCustomer();

    <T extends ProductCalculatorInput> List<T> getProducts();

    <T extends DeclarationCalculatorInput> List<T> getDeclarations();
}
