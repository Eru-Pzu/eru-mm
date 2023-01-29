package com.hexagonalmultimodule.productservices.query;

import com.hexagonalmultimodule.productapi.snapshot.ProductSnapshot;
import com.hexagonalmultimodule.productapi.snapshot.ProductSnapshotService;
import com.hexagonalmultimodule.productservices.port.ProductSnapshotSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultProductSnapshotService implements ProductSnapshotService {
    private final ProductSnapshotSearchRepository productSnapshotSearchRepository;

    @Override
    public ProductSnapshot findByProductId(Long productId) {
        return productSnapshotSearchRepository.findByProductId(productId);
    }

    @Override
    public List<ProductSnapshot> findAllByProductId(List<Long> productIds) {
        return productSnapshotSearchRepository.findAllById(productIds);
    }

}
