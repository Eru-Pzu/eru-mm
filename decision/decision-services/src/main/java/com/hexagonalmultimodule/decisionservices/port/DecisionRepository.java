package com.hexagonalmultimodule.decisionservices.port;

import com.hexagonalmultimodule.decisionport.order.model.DecisionPricingOrder;
import com.hexagonalmultimodule.decisionport.product.model.DecisionProduct;
import com.hexagonalmultimodule.decisionport.price.model.DecisionPrice;

import java.util.List;

public interface DecisionRepository {

    Long createFrom(DecisionPricingOrder pricingOrder, DecisionPrice price, List<DecisionProduct> products);
}
