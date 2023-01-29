package com.hexagonalmultimodule.orderport.customer;

import com.hexagonalmultimodule.orderport.common.OrderCustomerCalculationInput;

public interface OrderCustomerSearchService {
    OrderCustomerCalculationInput getCustomer(String customerId);
}
