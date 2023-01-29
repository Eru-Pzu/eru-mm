package com.hexagonalmultimodule.productport;

import java.util.List;

public interface ProductDeclarationRenewService {
    void renewByProductIds(List<Long> productIds);
}
