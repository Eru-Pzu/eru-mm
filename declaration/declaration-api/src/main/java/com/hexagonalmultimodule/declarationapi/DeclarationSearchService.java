package com.hexagonalmultimodule.declarationapi;

import com.hexagonalmultimodule.orderport.declaration.OrderDeclarationSearchService;

import java.util.List;

public interface DeclarationSearchService extends OrderDeclarationSearchService {
    @Override
    List<DeclarationDto> findAllByproductIds(List<Long> productIds);
}
