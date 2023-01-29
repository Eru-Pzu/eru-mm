package com.hexagonalmultimodule.orderport.price;

import com.hexagonalmultimodule.commons.calculator.CalculatorInput;

public interface OrderPriceService {
    Long create();

    void invalidate(Long priceId);

    Long calculate(CalculatorInput calculatorInput);
}
