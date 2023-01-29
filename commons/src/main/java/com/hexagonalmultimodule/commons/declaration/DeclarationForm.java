package com.hexagonalmultimodule.commons.declaration;

import lombok.Data;

@Data
public class DeclarationForm {
    private Long id;
    private String type;
    private Long productId;
    private Long amount;
}
