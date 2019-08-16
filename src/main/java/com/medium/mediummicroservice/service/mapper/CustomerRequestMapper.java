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

        Customer customer = new Customer();
        customer.setDocument(input.getDocument());
        customer.setCustomerCode(input.getCustomerCode());
        customer.setCompanyName(input.getCompanyName());

        return customer;
    }
}
