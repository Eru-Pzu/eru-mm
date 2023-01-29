package com.hexagonalmultimodule.productservices.port;


import com.hexagonalmultimodule.commons.declaration.DeclarationForm;

public interface DeclarationChangeAware {
    void onDeclarationChange(DeclarationForm declarationForm);
}
