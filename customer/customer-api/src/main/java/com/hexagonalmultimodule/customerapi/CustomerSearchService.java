package com.hexagonalmultimodule.customerapi;

import com.hexagonalmultimodule.orderport.customer.OrderCustomerSearchService;

public interface CustomerSearchService extends OrderCustomerSearchService {
    @Override
    CustomerDto getCustomer(String customerId);
}
