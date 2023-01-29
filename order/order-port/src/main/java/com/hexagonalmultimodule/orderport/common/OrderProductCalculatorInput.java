package com.hexagonalmultimodule.orderport.common;

import com.hexagonalmultimodule.commons.calculator.ProductCalculatorInput;

import java.util.List;

public interface OrderProductCalculatorInput extends ProductCalculatorInput {
    String getType();
    List<Long> getDeclarationIds();
}
