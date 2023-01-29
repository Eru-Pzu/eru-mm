package com.hexagonalmultimodule.productapi.renew;

import com.hexagonalmultimodule.orderport.product.OrderProductRenewService;

public interface ProductRenewService extends OrderProductRenewService {
    Long renewById(Long renewalableId);
}
