package com.kylemanagement.service;

import com.api.model.CustomerDto;
import com.kylemanagement.model.Customer;
import java.util.List;

public interface CustomerService {

    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto updateCustomer(Long customerId, CustomerDto customerDto);
    List<CustomerDto> getCustomers();
    CustomerDto findCustomerById(Long id);
    void deleteCustomerById(Long id);
}
