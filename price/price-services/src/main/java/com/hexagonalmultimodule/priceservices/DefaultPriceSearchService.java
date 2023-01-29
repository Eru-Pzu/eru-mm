package com.hexagonalmultimodule.priceservices;

import com.hexagonalmultimodule.priceapi.PriceDto;
import com.hexagonalmultimodule.priceapi.PriceSearchService;
import org.springframework.stereotype.Service;

@Service
public class DefaultPriceSearchService implements PriceSearchService {
    @Override
    public PriceDto get(Long priceId) {
        return new PriceDto();
    }
}
