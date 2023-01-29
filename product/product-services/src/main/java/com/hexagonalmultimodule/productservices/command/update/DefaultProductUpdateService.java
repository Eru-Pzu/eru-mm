package com.hexagonalmultimodule.productservices.command.update;

import com.hexagonalmultimodule.commons.product.ProductForm;
import com.hexagonalmultimodule.productport.ProductDeclarationService;
import com.hexagonalmultimodule.productservices.port.UpdateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

@Service
@RequiredArgsConstructor
public class DefaultProductUpdateService {
    private final UpdateRepository updateRepository;
    private final ProductDeclarationService productDeclarationService;

    @PutMapping()
    public void updateProduct(ProductForm form) {
        updateRepository.update(form);
        productDeclarationService.updateDeclarations(form);
    }
}
