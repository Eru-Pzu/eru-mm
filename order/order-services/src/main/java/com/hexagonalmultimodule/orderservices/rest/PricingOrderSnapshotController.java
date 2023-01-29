package com.hexagonalmultimodule.orderservices.rest;

import com.hexagonalmultimodule.orderapi.model.PricingOrderSnapshot;
import com.hexagonalmultimodule.orderapi.service.PricingOrderSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pricing/order")
public class PricingOrderSnapshotController {
    private final PricingOrderSearchService pricingOrderSearchService;

    @GetMapping("/{customerId}")
    public List<PricingOrderSnapshot> findAll(@PathVariable String customerId) {
        return pricingOrderSearchService.findAllByCustomerId(customerId);
    }

}
