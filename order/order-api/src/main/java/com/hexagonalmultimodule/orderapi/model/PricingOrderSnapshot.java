package com.hexagonalmultimodule.orderapi.model;

import com.hexagonalmultimodule.decisionport.order.model.DecisionPricingOrder;
import lombok.*;

import java.util.List;
import java.util.stream.Stream;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PricingOrderSnapshot implements DecisionPricingOrder, PriceParent {
    private Long id;
    private Long priceId;
    private String customerId;
    private String type;
    private List<Long> productIds;
}

