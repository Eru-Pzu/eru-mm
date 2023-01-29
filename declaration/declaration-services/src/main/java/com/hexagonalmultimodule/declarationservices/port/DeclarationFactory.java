package com.hexagonalmultimodule.declarationservices.port;

import com.hexagonalmultimodule.commons.declaration.DeclarationForm;

public interface DeclarationFactory {
    Long create(DeclarationForm form);
}
