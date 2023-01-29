package com.hexagonalmultimodule.priceapi;

import com.hexagonalmultimodule.decisionport.price.model.DecisionPrice;
import lombok.Data;

@Data
public class PriceDto implements DecisionPrice {
    private Long value;
}
