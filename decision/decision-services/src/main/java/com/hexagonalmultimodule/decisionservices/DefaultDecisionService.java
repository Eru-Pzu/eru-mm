package com.hexagonalmultimodule.decisionservices;

import com.hexagonalmultimodule.decisionapi.DecisionService;
import com.hexagonalmultimodule.decisionport.order.DecisionOrderSearchService;
import com.hexagonalmultimodule.decisionport.order.model.DecisionPricingOrder;
import com.hexagonalmultimodule.decisionport.product.DecisionProductSearchService;
import com.hexagonalmultimodule.decisionport.product.model.DecisionProduct;
import com.hexagonalmultimodule.decisionport.price.DecisionPriceSearchService;
import com.hexagonalmultimodule.decisionport.price.model.DecisionPrice;
import com.hexagonalmultimodule.decisionservices.port.DecisionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultDecisionService implements DecisionService {
    private final DecisionOrderSearchService decisionOrderSearchService;
    private final DecisionPriceSearchService decisionPriceSearchService;
    private final DecisionRepository decisionRepository;
    private final DecisionProductSearchService decisionProductSearchService;

    @Override
    public Long createFrom(String customerId) {
        DecisionPricingOrder pricingOrder = decisionOrderSearchService.findAllByCustomerId(customerId).stream()
                .findAny().orElseThrow();
        Long priceId = pricingOrder.getPriceId();
        DecisionPrice price = decisionPriceSearchService.get(priceId);
        List<DecisionProduct> products =
                (List<DecisionProduct>) decisionProductSearchService.findAllByDecisionProductId(pricingOrder.getProductIds());
        return decisionRepository.createFrom(pricingOrder, price, products);
    }
}
