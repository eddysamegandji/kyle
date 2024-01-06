package com.kylemanagement.controller;


import com.api.handler.CustomerResourceApi;
import com.api.model.CustomerApi;
import com.kylemanagement.service.CustomerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController implements CustomerResourceApi {

    private final CustomerService customerService;

    @Override
    public ResponseEntity<CustomerApi> createCustomer(CustomerApi customerApi) {
        return ResponseEntity.ok(customerService.saveCustomer(customerApi));
    }

    @Override
    public ResponseEntity<List<CustomerApi>> getCustomers() {
        return ResponseEntity.ok(customerService.getCustomers());
    }
}
