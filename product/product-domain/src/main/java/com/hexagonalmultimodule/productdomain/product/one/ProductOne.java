package com.hexagonalmultimodule.productdomain.product.one;

import com.hexagonalmultimodule.commons.declaration.DeclarationForm;
import com.hexagonalmultimodule.commons.product.ProductForm;
import com.hexagonalmultimodule.dddcommons.Aggregate;
import com.hexagonalmultimodule.productapi.snapshot.ProductOneSnapshot;
import com.hexagonalmultimodule.productapi.snapshot.ProductSnapshot;
import com.hexagonalmultimodule.productdomain.product.common.BaseProductData;
import com.hexagonalmultimodule.productservices.port.DeclarationChangeAware;
import com.hexagonalmultimodule.productservices.port.Renewal;
import com.hexagonalmultimodule.productservices.port.Renewalable;
import com.hexagonalmultimodule.productservices.port.WithDeclarations;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.ArrayList;
import java.util.List;

@Aggregate
@Entity
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorValue("productOne")
public class ProductOne extends BaseProductData implements Renewalable, Renewal, WithDeclarations, DeclarationChangeAware {
    private boolean renewed;
    private boolean renewal;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Long> declarationIds = new ArrayList<>();

    public static ProductOne from(ProductForm form) {
        ProductOne productOne = new ProductOne();
        productOne.setType(form.getType());
        productOne.setAmount(form.getAmount());
        return productOne;
    }

    @Override
    public ProductOne createRenewal() {
        ProductOne productOne = new ProductOne();
        productOne.setRenewal(true);
        productOne.setAmount(getAmount());
        productOne.setType(getType());
        markRenewed();
        return productOne;
    }

    public void updateFromForm(ProductForm form) {
        this.setAmount(form.getAmount());
    }

    @Override
    public void onDeclarationChange(DeclarationForm declarationForm) {

    }

    private void markRenewed() {
        this.renewed = true;
    }

    @Override
    public void addDeclaration(Long declarationId) {
        this.declarationIds.add(declarationId);
    }

    @Override
    public void removeDeclaration(Long declarationId) {
        this.declarationIds.remove(declarationId);
    }


    public ProductSnapshot snapshot() {
        return ProductOneSnapshot.builder()
                .id(this.getId())
                .type(this.getType())
                .amount(this.getAmount())
                .build();
    }
}
