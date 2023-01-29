package com.hexagonalmultimodule.decisionport.order.model;

import java.util.List;

public interface DecisionPricingOrder {
    Long getPriceId();

    String getType();

    List<Long> getProductIds();
}
