package com.medium.mediummicroservice.ws.v1;

import com.medium.mediummicroservice.model.request.CustomerRequest;
import com.medium.mediummicroservice.model.response.CustomerResponse;
import com.medium.mediummicroservice.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/v1")
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest customerRequest) {

        return ResponseEntity.ok(customerService.create(customerRequest));
    }

    @GetMapping
    public ResponseEntity<Page<CustomerResponse>> getAll(Pageable page) {

        Page<CustomerResponse> responses = customerService.getAll(page);

        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(@PathVariable("id") Long id, @RequestBody CustomerRequest customerRequest) {

        Optional<CustomerResponse> updated = customerService.update(id, customerRequest);

        if (!updated.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(updated.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> get(@PathVariable("id") Long id) {

        Optional<CustomerResponse> updated = customerService.get(id);

        if (!updated.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {

        LOGGER.info("Deleting price book {}", id);

        if (customerService.delete(id)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
