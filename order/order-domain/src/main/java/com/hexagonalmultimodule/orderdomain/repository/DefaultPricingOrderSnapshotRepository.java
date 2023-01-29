package com.hexagonalmultimodule.orderdomain.repository;

import com.hexagonalmultimodule.orderapi.model.PricingOrderSnapshot;
import com.hexagonalmultimodule.orderdomain.model.PricingOrder;
import com.hexagonalmultimodule.orderservices.port.PricingOrderSnapshotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class DefaultPricingOrderSnapshotRepository implements PricingOrderSnapshotRepository {
    private final DbPricingOrderRepository orderRepository;

    @Override
    public List<PricingOrderSnapshot> findAllByCustomerId(String customerId) {
        return orderRepository.findAllByCustomerId(customerId).stream()
                .map(PricingOrder::snapshot)
                .collect(Collectors.toList());
    }
}
