package com.hexagonalmultimodule.declarationservices;

import com.hexagonalmultimodule.declarationapi.DeclarationDto;
import com.hexagonalmultimodule.declarationapi.DeclarationSearchService;
import com.hexagonalmultimodule.declarationservices.port.DeclarationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultDeclarationSearchService implements DeclarationSearchService {
    private final DeclarationRepository declarationRepository;

    @Override
    public List<DeclarationDto> findAllByproductIds(List<Long> productIds) {
        return declarationRepository.findAllByproductIds(productIds);
    }
}
