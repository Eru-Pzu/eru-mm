package com.hexagonalmultimodule.declarationdomain;

import com.hexagonalmultimodule.commons.declaration.DeclarationForm;
import com.hexagonalmultimodule.commons.product.ProductForm;
import com.hexagonalmultimodule.declarationapi.DeclarationDto;
import com.hexagonalmultimodule.declarationservices.port.DeclarationFactory;
import com.hexagonalmultimodule.declarationservices.port.DeclarationRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class DefaultDeclarationRepository implements DeclarationFactory, DeclarationRepository {
    private final DbDeclarationRepository dbDeclarationRepository;

    @Override
    public Long create(DeclarationForm form) {
        Declaration declaration = new Declaration();
        declaration.setType(form.getType());
        declaration.setProductId(form.getProductId());
        declaration.setAmount(form.getAmount());
        return dbDeclarationRepository.save(declaration).getId();
    }

    @Override
    public void update(DeclarationForm form) {
        dbDeclarationRepository.findById(form.getId())
                .stream().peek(declaration -> declaration.updateFromForm(form))
                .forEach(dbDeclarationRepository::save);
    }

    @Override
    public void deleteAllByProductIdIn(List<Long> productIds) {
        dbDeclarationRepository.deleteAllByProductIdIn(productIds);
    }

    @Override
    public void updateDeclarations(ProductForm form) {
        dbDeclarationRepository.findById(form.getId())
                .stream().peek(declaration -> declaration.updateByProdcut(form))
                .forEach(dbDeclarationRepository::save);
    }

    @Override
    public List<DeclarationDto> findAllByproductIds(List<Long> productIds) {
        return dbDeclarationRepository.findAllByProductIdIn(productIds)
                .stream().map(Declaration::toDto)
                .collect(Collectors.toList());
    }

}
