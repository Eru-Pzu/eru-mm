package com.hexagonalmultimodule.productservices.port;


import com.hexagonalmultimodule.commons.declaration.DeclarationForm;

public interface WithDeclarationsRepository {
    void addDeclaration(Long productId, Long declarationId);

    void handleDeclarationChange(Long productId, DeclarationForm declarationForm);

    void handleDeclarationRemove(Long productId, Long declarationId);
}
