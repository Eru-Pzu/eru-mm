package com.hexagonalmultimodule.declarationservices;

import com.hexagonalmultimodule.commons.declaration.DeclarationForm;
import com.hexagonalmultimodule.commons.product.ProductForm;
import com.hexagonalmultimodule.declarationapi.DeclarationService;
import com.hexagonalmultimodule.declarationservices.port.DeclarationFactory;
import com.hexagonalmultimodule.declarationservices.port.DeclarationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultDeclarationService implements DeclarationService {
    private final DeclarationFactory declarationFactory;
    private final DeclarationRepository declarationRepository;

    @Override
    public Long create(DeclarationForm form) {
        return declarationFactory.create(form);
    }

    @Override
    public void update(DeclarationForm form) {
        declarationRepository.update(form);
    }

    @Override
    public void delete(Long declarationId) {
        declarationRepository.deleteAllByProductIdIn(List.of(declarationId));
    }

    @Override
    public void removeByProductId(Long productId) {
        declarationRepository.deleteAllByProductIdIn(List.of(productId));
    }

    @Override
    public void renewByProductIds(List<Long> productIds) {
        declarationRepository.deleteAllByProductIdIn(productIds);
    }

    @Override
    public void updateDeclarations(ProductForm form) {
        declarationRepository.updateDeclarations(form);

    }
}
