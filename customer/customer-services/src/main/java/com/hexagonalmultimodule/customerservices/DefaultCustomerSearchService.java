package com.hexagonalmultimodule.customerservices;

import com.hexagonalmultimodule.customerapi.CustomerDto;
import com.hexagonalmultimodule.customerapi.CustomerSearchService;
import org.springframework.stereotype.Service;

@Service
public class DefaultCustomerSearchService implements CustomerSearchService {

    @Override
    public CustomerDto getCustomer(String customerId) {
        return new CustomerDto();
    }
}
