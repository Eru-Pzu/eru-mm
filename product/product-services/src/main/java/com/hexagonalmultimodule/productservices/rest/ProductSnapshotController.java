package com.hexagonalmultimodule.productservices.rest;

import com.hexagonalmultimodule.productapi.snapshot.ProductSnapshot;
import com.hexagonalmultimodule.productservices.port.ProductSnapshotSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class ProductSnapshotController {
    private final ProductSnapshotSearchRepository productSnapshotSearchRepository;

    public ProductSnapshot findByProductId(Long productId) {
        return productSnapshotSearchRepository.findByProductId(productId);
    }
}
