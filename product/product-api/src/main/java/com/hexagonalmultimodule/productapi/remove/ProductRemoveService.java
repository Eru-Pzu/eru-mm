package com.hexagonalmultimodule.productapi.remove;

import com.hexagonalmultimodule.orderport.product.OrderProductRemoveService;

public interface ProductRemoveService extends OrderProductRemoveService {
    void removeProduct(String customerId, Long productId);
}
