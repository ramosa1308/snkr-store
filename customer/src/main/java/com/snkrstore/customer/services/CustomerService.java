package com.snkrstore.customer.services;

import com.snkrstore.customer.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);
}
