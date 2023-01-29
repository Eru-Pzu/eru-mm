package com.hexagonalmultimodule.decisionport.order;


import com.hexagonalmultimodule.decisionport.order.model.DecisionPricingOrder;

import java.util.List;

public interface DecisionOrderSearchService {
    <T extends DecisionPricingOrder> List<T> findAllByCustomerId(String customerId);
}
