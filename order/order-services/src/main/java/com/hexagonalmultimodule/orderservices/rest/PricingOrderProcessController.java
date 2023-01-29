package com.hexagonalmultimodule.orderservices.rest;

import com.hexagonalmultimodule.commons.product.ProductForm;
import com.hexagonalmultimodule.orderapi.service.PricingOrderProcessManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("pricing/order/process")
public class PricingOrderProcessController {
    private final PricingOrderProcessManager pricingOrderProcessManager;

    @PostMapping("/{customerId}")
    public Long create(@PathVariable String customerId) {
        return pricingOrderProcessManager.createOrderFor(customerId);
    }

    @PostMapping("/product")
    public Long addProduct(@RequestParam String customerId, @RequestBody ProductForm productForm) {
        return pricingOrderProcessManager.addProduct(customerId, productForm);
    }

    @DeleteMapping("/product")
    public void removeProduct(@RequestParam String customerId, @RequestParam Long productId) {
        pricingOrderProcessManager.removeProduct(customerId, productId);
    }

    @PostMapping("/renewal")
    public void renewProduct(@RequestParam String customerId, @RequestParam Long productId) {
        pricingOrderProcessManager.renewProduct(customerId, productId);
    }
}
