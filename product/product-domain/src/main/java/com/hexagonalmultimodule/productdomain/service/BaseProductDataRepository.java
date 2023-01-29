package com.hexagonalmultimodule.productdomain.service;


import com.hexagonalmultimodule.productdomain.product.common.BaseProductData;
import com.hexagonalmultimodule.productservices.port.DeclarationChangeAware;
import com.hexagonalmultimodule.productservices.port.Renewalable;
import com.hexagonalmultimodule.productservices.port.WithDeclarations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface BaseProductDataRepository extends JpaRepository<BaseProductData, Long> {
    default Optional<Renewalable> findRenewalableById(Long renewalId) {
        return findById(renewalId)
                .filter(p -> p instanceof Renewalable)
                .map(renewalable -> (Renewalable) renewalable);
    }

    default Optional<DeclarationChangeAware> findDeclarationChangeAware(Long productId) {
        return findById(productId)
                .filter(p -> p instanceof DeclarationChangeAware)
                .map(product -> (DeclarationChangeAware) product);
    }

    default Optional<WithDeclarations> findWithDeclarations(Long productId) {
        return findById(productId)
                .filter(p -> p instanceof WithDeclarations)
                .map(withDeclarations -> (WithDeclarations) withDeclarations);
    }

    default Long saveProduct(Object baseProductData) {
        if (baseProductData instanceof BaseProductData) {
            return save((BaseProductData) baseProductData).getId();
        } else {
            throw new UnsupportedOperationException();
        }
    }

}
