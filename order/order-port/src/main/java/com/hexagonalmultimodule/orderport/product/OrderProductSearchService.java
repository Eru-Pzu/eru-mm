package com.hexagonalmultimodule.orderport.product;

import com.hexagonalmultimodule.orderport.common.OrderProductCalculatorInput;

import java.util.List;

public interface OrderProductSearchService {
    OrderProductCalculatorInput findByProductId(Long productId);
    List<? extends OrderProductCalculatorInput> findAllByOrderProductId(List<Long> productIds);
}
