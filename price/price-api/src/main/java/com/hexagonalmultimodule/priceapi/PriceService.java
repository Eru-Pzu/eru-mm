package com.hexagonalmultimodule.priceapi;

import com.hexagonalmultimodule.commons.calculator.CalculatorInput;
import com.hexagonalmultimodule.orderport.price.OrderPriceService;

public interface PriceService extends OrderPriceService {
    Long create();

    void invalidate(Long priceId);

    Long calculate(CalculatorInput calculatorInput);

}
