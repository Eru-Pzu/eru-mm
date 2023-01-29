package com.hexagonalmultimodule.orderport.product;


import com.hexagonalmultimodule.commons.product.ProductForm;

public interface OrderProductFactory {
    Long create(ProductForm type);
}
