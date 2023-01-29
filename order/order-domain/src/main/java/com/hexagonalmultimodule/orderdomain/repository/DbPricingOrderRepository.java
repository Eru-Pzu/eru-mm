package com.hexagonalmultimodule.orderdomain.repository;

import com.hexagonalmultimodule.orderdomain.model.PricingOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DbPricingOrderRepository extends JpaRepository<PricingOrder, Long> {
    List<PricingOrder> findAllByCustomerId(String customerId);
}
