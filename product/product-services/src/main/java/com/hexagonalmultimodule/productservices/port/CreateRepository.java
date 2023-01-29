package com.hexagonalmultimodule.productservices.port;

import com.hexagonalmultimodule.commons.product.ProductForm;

public interface CreateRepository {
    Long create(ProductForm type);
}
