package com.hexagonalmultimodule.productservices.command.create;

import com.hexagonalmultimodule.commons.product.ProductForm;
import com.hexagonalmultimodule.productapi.create.ProductFactory;
import com.hexagonalmultimodule.productservices.port.CreateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class DefaultProductFactory implements ProductFactory {
    private final CreateRepository createRepository;

    @Override
    public Long create(ProductForm type) {
        return createRepository.create(type);
    }
}
