package com.medium.mediummicroservice.service;

import com.medium.mediummicroservice.model.request.CustomerRequest;
import com.medium.mediummicroservice.model.response.CustomerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CustomerService {

    CustomerResponse create(CustomerRequest customerRequest);

    Page<CustomerResponse> getAll(Pageable page);

    Optional<CustomerResponse> update(Long id, CustomerRequest customerRequest);

    Optional<CustomerResponse> get(Long id);

    boolean delete(Long id);
}
