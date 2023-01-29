package com.hexagonalmultimodule.productdomain.service;

import com.hexagonalmultimodule.productdomain.relation.ProductRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationRepository extends JpaRepository<ProductRelation, Long> {
    default Long addRelation(ProductRelation productRelation) {
        return this.save(productRelation).getId();
    }

    default void removeRelationsFor(Long productId) {
        this.deleteAllBySourceId(productId);
    }

    void deleteAllBySourceId(Long productId);
}
