package com.hexagonalmultimodule.productdomain.service;

import com.hexagonalmultimodule.productapi.snapshot.ProductSnapshot;
import com.hexagonalmultimodule.productapi.snapshot.WithSnapshot;
import com.hexagonalmultimodule.productservices.port.ProductSnapshotSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class DefaultProductSnapshotSearchRepository implements ProductSnapshotSearchRepository {
    private final BaseProductDataRepository baseProductDataRepository;

    @Override
    public ProductSnapshot findByProductId(Long productId) {
        return baseProductDataRepository.findById(productId).map(WithSnapshot::snapshot).orElseThrow();
    }

    public List<ProductSnapshot> findAllById(List<Long> productIds) {
        return baseProductDataRepository.findAllById(productIds).stream().map(WithSnapshot::snapshot).collect(Collectors.toList());
    }
}
