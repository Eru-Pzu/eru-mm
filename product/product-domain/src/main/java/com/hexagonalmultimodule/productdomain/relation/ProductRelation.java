package com.hexagonalmultimodule.productdomain.relation;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ProductRelation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String type;
    private Long sourceId;
    private Long targetId;

    public static ProductRelation from(String type, Long sourceId, Long targetId) {
        return ProductRelation.builder()
                .type(type)
                .sourceId(sourceId)
                .targetId(targetId)
                .build();
    }
}
