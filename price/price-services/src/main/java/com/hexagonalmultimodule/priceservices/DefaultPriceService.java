package com.hexagonalmultimodule.priceservices;

import com.hexagonalmultimodule.commons.calculator.CalculatorInput;
import com.hexagonalmultimodule.commons.calculator.CustomerCalculationInput;
import com.hexagonalmultimodule.commons.calculator.DeclarationCalculatorInput;
import com.hexagonalmultimodule.commons.calculator.ProductCalculatorInput;
import com.hexagonalmultimodule.priceapi.PriceService;
import com.hexagonalmultimodule.priceservices.port.PriceFactory;
import com.hexagonalmultimodule.priceservices.port.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultPriceService implements PriceService {
    private final PriceFactory PriceFactory;
    private final PriceRepository priceRepository;

    @Override
    public Long create() {
        return PriceFactory.create();
    }

    @Override
    public void invalidate(Long priceId) {
        priceRepository.invalidate(priceId);
    }

    @Override
    public Long calculate(CalculatorInput calculatorInput) {
        CustomerCalculationInput customer = calculatorInput.getCustomer();
        List<ProductCalculatorInput> products = calculatorInput.getProducts();
        List<DeclarationCalculatorInput> declarations = calculatorInput.getDeclarations();
        return 1L;
    }
}
