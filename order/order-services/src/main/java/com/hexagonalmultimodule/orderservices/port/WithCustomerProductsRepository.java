package com.hexagonalmultimodule.orderservices.port;

import com.hexagonalmultimodule.orderport.product.model.WithCustomerProducts;

import java.util.List;

public interface WithCustomerProductsRepository {
    Long createFor(String customerId, Long priceId);
    void addProduct(String customerId, Long productId, String type);
    List<? extends WithCustomerProducts> findAllByCustomerId(String customerId);
}
