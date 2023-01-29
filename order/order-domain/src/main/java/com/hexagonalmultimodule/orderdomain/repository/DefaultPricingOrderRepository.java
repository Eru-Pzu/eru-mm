package com.hexagonalmultimodule.orderdomain.repository;

import com.hexagonalmultimodule.dddcommons.DomainRepository;
import com.hexagonalmultimodule.orderdomain.model.PricingOrder;
import com.hexagonalmultimodule.orderdomain.policies.PricingOrderPolicy;
import com.hexagonalmultimodule.orderport.product.model.WithCustomerProducts;
import com.hexagonalmultimodule.orderservices.port.WithCustomerProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@DomainRepository
@Repository
@RequiredArgsConstructor
public class DefaultPricingOrderRepository implements WithCustomerProductsRepository {
    private final DbPricingOrderRepository orderRepository;
    private final List<PricingOrderPolicy> pricingOrderPolicies;

    @Override
    public Long createFor(String customerId, Long priceId) {
        return orderRepository.save(
                PricingOrder.builder().customerId(customerId).entries(List.of()).priceId(priceId).build()
        ).getId();
    }

    @Override
    public void addProduct(String customerId, Long productId, String productType) {
        orderRepository.findAllByCustomerId(customerId).stream().findAny().orElseThrow()
                .addProduct(customerId, productId, productType, pricingOrderPolicies);
    }

    @Override
    public List<? extends WithCustomerProducts> findAllByCustomerId(String customerId) {
        return orderRepository.findAllByCustomerId(customerId);
    }

}
