package com.hexagonalmultimodule.orderservices.query;

import com.hexagonalmultimodule.orderapi.model.PricingOrderSnapshot;
import com.hexagonalmultimodule.orderapi.service.PricingOrderSearchService;
import com.hexagonalmultimodule.orderport.common.OrderCustomerCalculationInput;
import com.hexagonalmultimodule.orderport.common.OrderDeclarationCalculatorInput;
import com.hexagonalmultimodule.orderport.common.OrderProductCalculatorInput;
import com.hexagonalmultimodule.orderport.customer.OrderCustomerSearchService;
import com.hexagonalmultimodule.orderport.declaration.OrderDeclarationSearchService;
import com.hexagonalmultimodule.orderport.price.OrderPriceService;
import com.hexagonalmultimodule.orderport.price.model.OrderCalculatorInput;
import com.hexagonalmultimodule.orderport.product.OrderProductSearchService;
import com.hexagonalmultimodule.orderservices.port.PricingOrderSnapshotRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultPricingOrderSearchService implements PricingOrderSearchService {
    private final PricingOrderSnapshotRepository pricingOrderSnapshotRepository;
    private final OrderPriceService priceService;
    private final OrderCustomerSearchService customerSearchService;
    private final OrderProductSearchService productSearchService;

    private final OrderDeclarationSearchService declarationSearchService;

    public List<PricingOrderSnapshot> findAllByCustomerId(String customerId) {
        return pricingOrderSnapshotRepository.findAllByCustomerId(customerId);
    }

    @Override
    public Long getPrice(String customerId) {
        List<PricingOrderSnapshot> orderSnapshots = this.findAllByCustomerId(customerId);
        PricingOrderSnapshot orderSnapshot = orderSnapshots.stream().findAny().orElseThrow();

        OrderCustomerCalculationInput customer = customerSearchService.getCustomer(customerId);
        List<OrderProductCalculatorInput> orderProducts =
                (List<OrderProductCalculatorInput>) productSearchService.findAllByOrderProductId(orderSnapshot.getProductIds());
        List<OrderDeclarationCalculatorInput> orderDeclarations =
                (List<OrderDeclarationCalculatorInput>) declarationSearchService.findAllByproductIds(orderSnapshot.getProductIds());

        return priceService.calculate(OrderCalculatorInput.builder()
                .priceId(orderSnapshot.getPriceId())
                .customer(customer)
                .products(orderProducts)
                .declarations(orderDeclarations)
                .build()
        );
    }
}
