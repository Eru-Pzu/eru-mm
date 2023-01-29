package com.hexagonalmultimodule.orderdomain.model;

import com.hexagonalmultimodule.dddcommons.Aggregate;
import com.hexagonalmultimodule.orderapi.model.PricingOrderSnapshot;
import com.hexagonalmultimodule.orderdomain.policies.PricingOrderPolicy;
import com.hexagonalmultimodule.orderport.product.model.WithCustomerProducts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Aggregate
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PricingOrder implements WithCustomerProducts {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private String customerId;

    @Column
    private Long priceId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PricingOrderEntry> entries;

    public void addProduct(String customerId, Long productId, String type, Collection<PricingOrderPolicy> policies) {
        entries.add(PricingOrderEntry.from(customerId, productId, type));
        policies.forEach(policy -> policy.validate(this));
    }

    @Override
    public void removeProduct(String customerId, Long productId) {
        entries.removeIf(entry -> entry.getProductId().equals(productId) && entry.getCustomerId().equals(customerId));
    }

    public PricingOrderSnapshot snapshot() {
        return PricingOrderSnapshot
                .builder()
                .id(this.id)
                .priceId(this.priceId)
                .customerId(this.customerId)
                .productIds(entries.stream().map(PricingOrderEntry::getProductId).collect(Collectors.toList()))
                .type("FIRST")
                .build();
    }
}
