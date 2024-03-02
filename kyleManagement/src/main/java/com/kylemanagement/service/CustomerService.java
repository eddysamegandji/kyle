package com.kylemanagement.service;

import com.api.model.CustomerDto;
import com.kylemanagement.model.Customer;
import java.util.List;

public interface CustomerService {

    CustomerDto saveCustomer(CustomerDto customerApi);
    Customer updateCustomer(Long customerId, CustomerDto customerDto);
    List<CustomerDto> getCustomers();
    CustomerDto findCustomerById(Long id);
    void deleteCustomerById(Long id);
}
