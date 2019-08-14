package com.medium.mediummicroservice.service.mapper;

import com.medium.mediummicroservice.model.request.CustomerRequest;
import com.medium.mediummicroservice.persistence.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerRequestMapper implements Mapper<CustomerRequest, Customer> {

    @Override
    public Customer map(CustomerRequest input) {
        if (input == null) {
            return null;
        }

        Customer customer = new Customer().builder()
                .document(input.getDocument())
                .customerCode(input.getCustomerCode())
                .companyName(input.getCompanyName()).build();

        return customer;
    }
}
