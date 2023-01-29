package com.hexagonalmultimodule.orderdomain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class PricingOrderEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String customerId;
    private Long productId;
    private String productType;

    public static PricingOrderEntry from(String customerId, Long productId, String type) {
        PricingOrderEntry pricingOrderEntry = new PricingOrderEntry();
        pricingOrderEntry.setCustomerId(customerId);
        pricingOrderEntry.setProductId(productId);
        pricingOrderEntry.setProductType(type);
        return pricingOrderEntry;
    }
}
