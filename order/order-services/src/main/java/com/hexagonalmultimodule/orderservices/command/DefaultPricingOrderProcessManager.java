package com.hexagonalmultimodule.orderservices.command;

import com.hexagonalmultimodule.commons.product.ProductForm;
import com.hexagonalmultimodule.orderapi.model.PriceParent;
import com.hexagonalmultimodule.orderapi.service.PricingOrderProcessManager;
import com.hexagonalmultimodule.orderport.product.OrderProductSearchService;
import com.hexagonalmultimodule.orderport.common.OrderProductCalculatorInput;
import com.hexagonalmultimodule.orderport.product.OrderProductFactory;
import com.hexagonalmultimodule.orderport.product.OrderProductRemoveService;
import com.hexagonalmultimodule.orderport.product.OrderProductRenewService;
import com.hexagonalmultimodule.orderport.product.model.WithCustomerProducts;
import com.hexagonalmultimodule.orderport.price.OrderPriceService;
import com.hexagonalmultimodule.orderservices.port.PricingOrderSnapshotRepository;
import com.hexagonalmultimodule.orderservices.port.WithCustomerProductsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Klasa odpowiedzialna tylko za logikę koordynacyjną (SRP) modułów przechoujących stan
 * - komponent wie co musi się zadziać w ramach ACID - atomicity, consistency, isolation, durability
 * na poziomeie integracji miedzymodułowej
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class DefaultPricingOrderProcessManager implements PricingOrderProcessManager {
    private final OrderProductFactory productFactory;
    private final OrderProductSearchService productSearchService;
    private final OrderProductRenewService productRenewService;
    private final OrderProductRemoveService productRemoveService;
    private final OrderPriceService priceService;
    private final WithCustomerProductsRepository withCustomerProductsRepository;
    private final PricingOrderSnapshotRepository snapshotRepository;

    @Override
    public Long createOrderFor(String customerId) {
        Long priceId = priceService.create();
        return withCustomerProductsRepository.createFor(customerId, priceId);
    }

    @Override
    public Long addProduct(String customerId, ProductForm productForm) {
        Long productId = productFactory.create(productForm);
        withCustomerProductsRepository.addProduct(customerId, productId, productForm.getType());
        this.invalidatePrice(customerId);
        return productId;
    }

    @Override
    public void removeProduct(String customerId, Long productId) {
        productRemoveService.removeProduct(customerId, productId);
        WithCustomerProducts pricingOrder = withCustomerProductsRepository.findAllByCustomerId(customerId)
                .stream().findAny().orElseThrow();
        /**
         * zbędne upublicznienie * WithCustomerProducts::removeProduct * można zamknąć zachowanie w domenie
         * */
        pricingOrder.removeProduct(customerId, productId);
        this.invalidatePrice(customerId);
    }

    @Override
    public void renewProduct(String customerId, Long productId) {
        Long renewalId = productRenewService.renewById(productId);
        OrderProductCalculatorInput renewal = productSearchService.findByProductId(renewalId);
        withCustomerProductsRepository.addProduct(customerId, productId, renewal.getType());
        this.invalidatePrice(customerId);
    }

    private void invalidatePrice(String customerId) {
        PriceParent priceParent = snapshotRepository.findAllByCustomerId(customerId)
                .stream().findAny().orElseThrow();
        priceService.invalidate(priceParent.getPriceId());
    }
}
