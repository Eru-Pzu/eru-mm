package com.hexagonalmultimodule.priceapi;

import com.hexagonalmultimodule.decisionport.price.DecisionPriceSearchService;

public interface PriceSearchService extends DecisionPriceSearchService {
    @Override
    PriceDto get(Long priceId);
}
