package com.hexagonalmultimodule.declarationapi;

import com.hexagonalmultimodule.commons.product.ProductForm;
import com.hexagonalmultimodule.commons.declaration.DeclarationForm;
import com.hexagonalmultimodule.productport.ProductDeclarationFactory;
import com.hexagonalmultimodule.productport.ProductDeclarationRemoveService;
import com.hexagonalmultimodule.productport.ProductDeclarationRenewService;
import com.hexagonalmultimodule.productport.ProductDeclarationService;

import java.util.List;

public interface DeclarationService extends ProductDeclarationRemoveService, ProductDeclarationRenewService, ProductDeclarationService, ProductDeclarationFactory {
    @Override
    Long create(DeclarationForm declarationForm);

    @Override
    void removeByProductId(Long productId);

    @Override
    void renewByProductIds(List<Long> productIds);

    @Override
    void update(DeclarationForm declarationForm);

    @Override
    void updateDeclarations(ProductForm form);

    @Override
    void delete(Long declarationId);
}
