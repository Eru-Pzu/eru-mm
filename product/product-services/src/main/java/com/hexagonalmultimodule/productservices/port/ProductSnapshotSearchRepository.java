package com.hexagonalmultimodule.productservices.port;

import com.hexagonalmultimodule.productapi.snapshot.ProductSnapshot;

import java.util.List;

public interface ProductSnapshotSearchRepository {
    ProductSnapshot findByProductId(Long productId);

    List<ProductSnapshot> findAllById(List<Long> productIds);
}
