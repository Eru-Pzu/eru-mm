package com.hexagonalmultimodule.orderport.product.model;


public interface WithCustomerProducts {

    void removeProduct(String customerId, Long productId);
}
