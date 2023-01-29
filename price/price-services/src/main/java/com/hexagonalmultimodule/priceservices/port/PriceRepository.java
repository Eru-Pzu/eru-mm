package com.hexagonalmultimodule.priceservices.port;

public interface PriceRepository {
    void invalidate(Long priceId);
}
