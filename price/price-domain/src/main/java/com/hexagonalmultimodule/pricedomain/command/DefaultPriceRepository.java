package com.hexagonalmultimodule.pricedomain.command;

import com.hexagonalmultimodule.priceservices.port.PriceFactory;
import com.hexagonalmultimodule.priceservices.port.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DefaultPriceRepository implements PriceRepository, PriceFactory {
    private final DbPriceRepository priceRepository;
    @Override
    public Long create() {
        return priceRepository.save(new Price()).getId();
    }

    @Override
    public void invalidate(Long priceId) {
        priceRepository.findById(priceId).map(Invalidateable::invalidate).orElseThrow();
    }
}
