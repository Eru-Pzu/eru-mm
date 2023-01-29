package com.hexagonalmultimodule.declarationservices.port;


import com.hexagonalmultimodule.commons.declaration.DeclarationForm;
import com.hexagonalmultimodule.commons.product.ProductForm;
import com.hexagonalmultimodule.declarationapi.DeclarationDto;

import java.util.List;

public interface DeclarationRepository {
    void update(DeclarationForm form);

    void deleteAllByProductIdIn(List<Long> productIds);

    void updateDeclarations(ProductForm form);

    List<DeclarationDto> findAllByproductIds(List<Long> productIds);
}
