package com.hexagonalmultimodule.productservices.declaration;

import com.hexagonalmultimodule.commons.declaration.DeclarationForm;
import com.hexagonalmultimodule.productport.ProductDeclarationFactory;
import com.hexagonalmultimodule.productport.ProductDeclarationService;
import com.hexagonalmultimodule.productservices.port.WithDeclarationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@RequiredArgsConstructor
public class DefaultProductDeclarationService {
    private final ProductDeclarationFactory productDeclarationFactory;
    private final WithDeclarationsRepository withDeclarationsRepository;
    private final ProductDeclarationService productDeclarationService;

    public Long addDeclarationToProduct(Long productId, DeclarationForm declarationForm) {
        Long declarationId = productDeclarationFactory.create(declarationForm);
        withDeclarationsRepository.addDeclaration(productId, declarationId);
        return declarationId;
    }

    public void updateDeclaration(Long productId, DeclarationForm declarationForm) {
        productDeclarationService.update(declarationForm);
        withDeclarationsRepository.handleDeclarationChange(productId, declarationForm);
    }

    public void deleteDeclaration(Long productId, Long declarationId) {
        productDeclarationService.delete(declarationId);
        withDeclarationsRepository.handleDeclarationRemove(productId, declarationId);
    }
}
