package com.hexagonalmultimodule.orderservices.port;

import com.hexagonalmultimodule.orderapi.model.PricingOrderSnapshot;

import java.util.List;

public interface PricingOrderSnapshotRepository {
    List<PricingOrderSnapshot> findAllByCustomerId(String customerId);
}
