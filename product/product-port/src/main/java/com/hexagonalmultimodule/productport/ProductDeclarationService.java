package com.hexagonalmultimodule.productport;

import com.hexagonalmultimodule.commons.product.ProductForm;
import com.hexagonalmultimodule.commons.declaration.DeclarationForm;

public interface ProductDeclarationService {
    void update(DeclarationForm declarationForm);
    void updateDeclarations(ProductForm form);
    void delete(Long declarationId);
}
