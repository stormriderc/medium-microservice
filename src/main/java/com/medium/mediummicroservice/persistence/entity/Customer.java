package com.medium.mediummicroservice.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.function.Function;

@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "document", length = 14, nullable = false)
    private String document;

    @Column(name = "customer_code", nullable = false)
    private String customerCode;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    public <R> R map(Function<Customer, R> func) {
        return func.apply(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public static CustomerBuilder builder() {
        return CustomerBuilder.aCustomer();
    }

    public static final class CustomerBuilder {
        private Long id;
        private String document;
        private String customerCode;
        private String companyName;

        private CustomerBuilder() {
        }

        public static CustomerBuilder aCustomer() {
            return new CustomerBuilder();
        }

        public CustomerBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CustomerBuilder document(String document) {
            this.document = document;
            return this;
        }

        public CustomerBuilder customerCode(String customerCode) {
            this.customerCode = customerCode;
            return this;
        }

        public CustomerBuilder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Customer build() {
            Customer customer = new Customer();
            customer.setId(id);
            customer.setDocument(document);
            customer.setCustomerCode(customerCode);
            customer.setCompanyName(companyName);
            return customer;
        }
    }
}
