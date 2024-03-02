package com.kylemanagement.controller;


import com.api.handler.CustomerResourceApi;
import com.api.model.CustomerDto;
import com.kylemanagement.service.CustomerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class CustomerController implements CustomerResourceApi {

    final CustomerService customerService;
    @Override
    public ResponseEntity<CustomerDto> createCustomer(CustomerDto customerDto) {
        CustomerDto savedCustomerDto = customerService.createCustomer(customerDto);
        return savedCustomerDto == null ? badRequest().build() : new ResponseEntity<>(savedCustomerDto, HttpStatus.CREATED);
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
        CustomerDto updatedCustomerDto = customerService.updateCustomer(id, customerDto);
        return updatedCustomerDto == null ? notFound().build() : ok(updatedCustomerDto);
    }

    @Override
    public ResponseEntity<CustomerDto> getCustomer(Long id) {
        CustomerDto customerDto = customerService.findCustomerById(id);
        return customerDto == null ? notFound().build() : ok(customerDto);
    }

    @Override
    public ResponseEntity<List<CustomerDto>> getCustomers() {
        List<CustomerDto> customerDtos = customerService.getCustomers();
        return customerDtos.isEmpty() ? noContent().build() : ok(customerDtos);
    }
}
