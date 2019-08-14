package com.medium.mediummicroservice.model.request;

import javax.validation.constraints.NotBlank;

public class CustomerRequest {

    @NotBlank
    private String document;

    @NotBlank
    private String customerCode;

    @NotBlank
    private String companyName;

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
