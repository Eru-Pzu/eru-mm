package com.hexagonalmultimodule.productapi.snapshot;

import com.hexagonalmultimodule.decisionport.product.model.DecisionProduct;
import com.hexagonalmultimodule.orderport.common.OrderProductCalculatorInput;

public interface ProductSnapshot extends OrderProductCalculatorInput, DecisionProduct {
    Long getId();
    Long getAmount();
    String getType();
}
