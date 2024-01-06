package com.kylemanagement.controller;


import com.api.handler.CustomerResourceApi;
import com.api.model.CustomerApi;
import com.kylemanagement.service.CustomerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class CustomerController implements CustomerResourceApi {

    private final CustomerService customerService;

    @Override
    public ResponseEntity<CustomerApi> createCustomer(CustomerApi customerApi) {
        CustomerApi savedCustomer = customerService.saveCustomer(customerApi);
        if (savedCustomer != null)
            return ok(savedCustomer);
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
    public ResponseEntity<CustomerApi> editCustomer(Long id, CustomerApi customerApi) {
        if (customerService.findCustomerById(id) != null)
            return ok(customerService.saveCustomer(customerApi));
        return notFound().build();
    }

    @Override
    public ResponseEntity<CustomerApi> getCustomer(Long id) {
        CustomerApi customer = customerService.findCustomerById(id);
        return customer == null ? notFound().build() : ok(customer);
    }

    @Override
    public ResponseEntity<List<CustomerApi>> getCustomers() {
        List<CustomerApi> result = customerService.getCustomers();
        return result.isEmpty() ? noContent().build() : ok(result);
    }
}
