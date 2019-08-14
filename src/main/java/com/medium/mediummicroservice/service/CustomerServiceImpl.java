package com.medium.mediummicroservice.service;

import com.medium.mediummicroservice.model.request.CustomerRequest;
import com.medium.mediummicroservice.model.response.CustomerResponse;
import com.medium.mediummicroservice.persistence.entity.Customer;
import com.medium.mediummicroservice.persistence.repository.CustomerRepository;
import com.medium.mediummicroservice.service.mapper.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private Mapper<CustomerRequest, Customer> customerRequestMapper;

    @Autowired
    private Mapper<Customer, CustomerResponse> customerResponseMapper;


    @Override
    public CustomerResponse create(CustomerRequest customerRequest) {

        notNull(customerRequest, "Request inválida");

        Customer customer = this.customerRequestMapper.map(customerRequest);

        return customerRepository.saveAndFlush(customer).map((Customer input) -> this.customerResponseMapper.map(input));
    }

    @Override
    public Page<CustomerResponse> getAll(Pageable page) {

        notNull(page, "Página inválida");
        return customerRepository.findAll(page).map(cr -> this.customerResponseMapper.map(cr));

    }

    @Override
    public Optional<CustomerResponse> update(Long id, CustomerRequest customerRequest) {

        notNull(id, "ID inválido");

        Customer updateData = this.customerRequestMapper.map(customerRequest);

        return customerRepository.findById(id)
                .map(customer -> {

                    customer.setCompanyName(updateData.getCompanyName());
                    customer.setCustomerCode(updateData.getCustomerCode());
                    customer.setDocument(updateData.getDocument());

                    return this.customerResponseMapper.map(customerRepository.saveAndFlush(customer));
                });
    }

    @Override
    public Optional<CustomerResponse> get(Long id) {
        notNull(id, "ID inválido");

        return customerRepository.findById(id).map(this.customerResponseMapper::map);
    }

    @Override
    public boolean delete(Long id) {

        notNull(id, "ID inválido");

        try {
            customerRepository.deleteById(id);
            return true;
        } catch (Exception ex) {
            LOGGER.warn("Erro ao apagar registro {}", id, ex);
        }

        return false;
    }
}
