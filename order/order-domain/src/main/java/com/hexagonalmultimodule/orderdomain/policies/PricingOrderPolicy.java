package com.hexagonalmultimodule.orderdomain.policies;

import com.hexagonalmultimodule.orderdomain.model.PricingOrder;

public interface PricingOrderPolicy {
    void validate(PricingOrder pricingOrder);
}
