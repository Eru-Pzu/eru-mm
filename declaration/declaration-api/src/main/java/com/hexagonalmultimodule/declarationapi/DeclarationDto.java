package com.hexagonalmultimodule.declarationapi;

import com.hexagonalmultimodule.orderport.common.OrderDeclarationCalculatorInput;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DeclarationDto implements OrderDeclarationCalculatorInput {
    private Long id;
    private Long productId;
    private String type;
    private Long amount;
}
