package com.hexagonalmultimodule.productservices.command.renew;

import com.hexagonalmultimodule.productapi.renew.ProductRenewService;
import com.hexagonalmultimodule.productport.ProductDeclarationRenewService;
import com.hexagonalmultimodule.productservices.port.RenewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class DefaultProductRenewService implements ProductRenewService {
    private final RenewRepository renewRepository;
    private final ProductDeclarationRenewService productDeclarationRenewService;

    @Transactional
    public Long renewById(Long renewalableId) {
        Long renewalId = renewRepository.renewById(renewalableId);
        productDeclarationRenewService.renewByProductIds(List.of(renewalableId, renewalId));
        return renewalId;
    }
}
