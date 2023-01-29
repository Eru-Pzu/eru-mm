package com.hexagonalmultimodule.productapi.snapshot;

import com.hexagonalmultimodule.decisionport.product.DecisionProductSearchService;
import com.hexagonalmultimodule.decisionport.product.model.DecisionProduct;
import com.hexagonalmultimodule.orderport.product.OrderProductSearchService;
import com.hexagonalmultimodule.orderport.common.OrderProductCalculatorInput;

import java.util.List;
import java.util.stream.Collectors;

public interface ProductSnapshotService extends OrderProductSearchService, DecisionProductSearchService {
    ProductSnapshot findByProductId(Long productId);

    default List<ProductSnapshot> findAllByOrderProductId(List<Long> productIds) {
        return findAllByProductId(productIds)
                .stream()
                .map(ProductSnapshot.class::cast)
                .collect(Collectors.toList());
    }

    default List<ProductSnapshot> findAllByDecisionProductId(List<Long> productIds) {
        return findAllByProductId(productIds)
                .stream()
                .map(ProductSnapshot.class::cast)
                .collect(Collectors.toList());
    }

    List<ProductSnapshot> findAllByProductId(List<Long> productIds);

}
