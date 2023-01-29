package com.hexagonalmultimodule.orderport.price.model;

import com.hexagonalmultimodule.commons.calculator.CalculatorInput;
import com.hexagonalmultimodule.orderport.common.OrderCustomerCalculationInput;
import com.hexagonalmultimodule.orderport.common.OrderDeclarationCalculatorInput;
import com.hexagonalmultimodule.orderport.common.OrderProductCalculatorInput;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class OrderCalculatorInput implements CalculatorInput {
    private Long priceId;
    private OrderCustomerCalculationInput customer;
    private List<OrderProductCalculatorInput> products;
    private List<OrderDeclarationCalculatorInput> declarations;
}
