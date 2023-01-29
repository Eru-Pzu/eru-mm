package com.hexagonalmultimodule.productport;

import com.hexagonalmultimodule.commons.declaration.DeclarationForm;

public interface ProductDeclarationFactory {
    Long create(DeclarationForm type);
}
