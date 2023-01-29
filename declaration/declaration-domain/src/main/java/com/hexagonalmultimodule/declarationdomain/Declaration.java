package com.hexagonalmultimodule.declarationdomain;

import com.hexagonalmultimodule.commons.declaration.DeclarationForm;
import com.hexagonalmultimodule.commons.product.ProductForm;
import com.hexagonalmultimodule.declarationapi.DeclarationDto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class Declaration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long productId;
    private String type;
    private Long amount;

    public void updateFromForm(DeclarationForm form) {
       this.amount = form.getAmount();
    }

    public void updateByProdcut(ProductForm form) {
        this.amount = null;
    }

    public DeclarationDto toDto() {
        return DeclarationDto.builder()
                .id(this.id)
                .productId(this.productId)
                .type(this.type)
                .amount(this.amount)
                .build();
    }
}
