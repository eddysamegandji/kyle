package com.kylemanagement.controller;


import com.api.handler.CustomerResourceApi;
import com.api.model.CustomerDto;
import com.kylemanagement.mapper.CustomerMapper;
import com.kylemanagement.model.Customer;
import com.kylemanagement.service.CustomerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequiredArgsConstructor
public class CustomerController implements CustomerResourceApi {

    private final CustomerService customerService;
    final CustomerMapper customerMapper;

    @Override
    public ResponseEntity<CustomerDto> createCustomer(CustomerDto customerDto) {
        CustomerDto savedCustomer = customerService.saveCustomer(customerDto);
        if (savedCustomer != null)
            return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
        return badRequest().build();
    }

    @Override
    public ResponseEntity<Void> deleteCustomer(Long id) {
        if (customerService.findCustomerById(id) != null) {
            customerService.deleteCustomerById(id);
            return noContent().build();
        }
        return notFound().build();
    }

    @Override
    public ResponseEntity<CustomerDto> editCustomer(Long id, CustomerDto customerDto) {
        Customer updatedCustomer = customerService.updateCustomer(id, customerDto);
        return updatedCustomer == null ? notFound().build() : ok(customerMapper.toCustomerDto(updatedCustomer));
    }

    @Override
    public ResponseEntity<CustomerDto> getCustomer(Long id) {
        CustomerDto customer = customerService.findCustomerById(id);
        return customer == null ? notFound().build() : ok(customer);
    }

    @Override
    public ResponseEntity<List<CustomerDto>> getCustomers() {
        List<CustomerDto> result = customerService.getCustomers();
        return result.isEmpty() ? noContent().build() : ok(result);
    }
}
