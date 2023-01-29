package com.hexagonalmultimodule.productservices.rest;

import com.hexagonalmultimodule.commons.declaration.DeclarationForm;
import com.hexagonalmultimodule.commons.product.ProductForm;
import com.hexagonalmultimodule.productservices.command.update.DefaultProductUpdateService;
import com.hexagonalmultimodule.productservices.declaration.DefaultProductDeclarationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
class ProductProcessController {
    private final DefaultProductUpdateService defaultProductUpdateService;
    private final DefaultProductDeclarationService defaultProductDeclarationService;

    @PutMapping()
    public void updateProduct(@RequestBody ProductForm form) {
        defaultProductUpdateService.updateProduct(form);
    }

    @PostMapping("/{productId}/declaration")
    public Long addDeclarationToProduct(@PathVariable Long productId, @RequestBody DeclarationForm declarationForm) {
        return defaultProductDeclarationService.addDeclarationToProduct(productId, declarationForm);
    }

    @PutMapping("/{productId}/declaration")
    public void updateDeclaration(@PathVariable Long productId, @RequestBody DeclarationForm declarationForm) {
        defaultProductDeclarationService.updateDeclaration(productId, declarationForm);
    }

    @DeleteMapping("/{productId}/declaration/{declarationId}")
    public void updateDeclaration(@PathVariable Long productId, @PathVariable Long declarationId) {
        defaultProductDeclarationService.deleteDeclaration(productId, declarationId);
    }
}
