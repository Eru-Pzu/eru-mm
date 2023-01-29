package com.hexagonalmultimodule.productapi.snapshot;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BaseProductDataSnapshot implements ProductSnapshot {
    private Long id;
    private Long amount;
    private String type;
    private List<Long> declarationIds;
}
