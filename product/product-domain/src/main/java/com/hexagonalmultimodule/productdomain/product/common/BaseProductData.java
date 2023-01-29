package com.hexagonalmultimodule.productdomain.product.common;

import com.hexagonalmultimodule.commons.product.ProductForm;
import com.hexagonalmultimodule.dddcommons.Aggregate;
import com.hexagonalmultimodule.productapi.snapshot.BaseProductDataSnapshot;
import com.hexagonalmultimodule.productapi.snapshot.ProductSnapshot;
import com.hexagonalmultimodule.productapi.snapshot.WithSnapshot;
import lombok.*;

import javax.persistence.*;

@Aggregate
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class BaseProductData implements WithSnapshot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long amount;

    @Column(insertable = false, updatable = false)
    private String type;

    public void updateFromForm(ProductForm form) {}

    public ProductSnapshot snapshot() {
        return BaseProductDataSnapshot.builder()
                .id(this.id)
                .amount(this.amount)
                .type(this.type)
                .build();
    }

}
