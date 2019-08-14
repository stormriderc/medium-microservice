package com.medium.mediummicroservice.service.mapper;

import com.medium.mediummicroservice.model.response.CustomerResponse;
import com.medium.mediummicroservice.persistence.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerResponseMapper implements Mapper<Customer, CustomerResponse> {


    @Override
    public CustomerResponse map(Customer input) {
        if (input == null) {
            return null;
        }

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(input.getId());
        customerResponse.setDocument(input.getDocument());
        customerResponse.setCompanyName(input.getCompanyName());
        customerResponse.setCustomerCode(input.getCustomerCode());

        return customerResponse;
    }
}
