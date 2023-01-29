package com.hexagonalmultimodule.decisionport.price;

import com.hexagonalmultimodule.decisionport.price.model.DecisionPrice;

public interface DecisionPriceSearchService {
    DecisionPrice get(Long priceId);
}
