package com.hexagonalmultimodule.decisiondomain.model;

import com.hexagonalmultimodule.decisionport.order.model.DecisionPricingOrder;
import com.hexagonalmultimodule.decisionport.product.model.DecisionProduct;
import com.hexagonalmultimodule.decisionport.price.model.DecisionPrice;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class Decision {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String poType;
    private Long price;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> productTypes;

    public static Decision from(DecisionPricingOrder po, DecisionPrice price, List<DecisionProduct> products) {
        return Decision.builder()
                .poType(po.getType())
                .price(price.getValue())
                .productTypes(products.stream().map(DecisionProduct::getType).collect(Collectors.toList()))
                .build();
    }
}
