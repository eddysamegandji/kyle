package com.kylemanagement.service;

import com.api.model.CustomerApi;
import java.util.List;

public interface CustomerService {

    CustomerApi saveCustomer(CustomerApi customerApi);
    List<CustomerApi> getCustomers();
    CustomerApi findCustomerById(Long id);
    void deleteCustomerById(Long id);
}
