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

}
