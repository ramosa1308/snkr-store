package com.snkrstore.customer.services;

import com.snkrstore.customer.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().uuid(UUID.randomUUID())
                .address("Octavio Morales")
                .age(31).name("Raul Morandeyra")
                .sex("M")
                .build();
    }
}
