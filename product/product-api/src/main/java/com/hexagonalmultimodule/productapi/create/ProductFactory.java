package com.hexagonalmultimodule.productapi.create;

import com.hexagonalmultimodule.commons.product.ProductForm;
import com.hexagonalmultimodule.orderport.product.OrderProductFactory;

public interface ProductFactory extends OrderProductFactory {
    Long create(ProductForm type);
}
