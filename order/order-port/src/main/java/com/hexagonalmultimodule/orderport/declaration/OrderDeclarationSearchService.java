package com.hexagonalmultimodule.orderport.declaration;

import com.hexagonalmultimodule.orderport.common.OrderDeclarationCalculatorInput;

import java.util.List;

public interface OrderDeclarationSearchService {
    List<? extends OrderDeclarationCalculatorInput> findAllByproductIds(List<Long> productIds);
}
