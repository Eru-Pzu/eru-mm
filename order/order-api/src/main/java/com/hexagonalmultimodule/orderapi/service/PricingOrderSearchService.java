package com.hexagonalmultimodule.orderapi.service;

import com.hexagonalmultimodule.decisionport.order.DecisionOrderSearchService;
import com.hexagonalmultimodule.orderapi.model.PricingOrderSnapshot;

import java.util.List;

public interface PricingOrderSearchService extends DecisionOrderSearchService {
    List<PricingOrderSnapshot> findAllByCustomerId(String customerId);
    Long getPrice(String customerId);
}
