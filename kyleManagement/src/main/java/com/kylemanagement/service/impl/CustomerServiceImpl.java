package com.kylemanagement.service.impl;

import com.api.model.CustomerApi;
import com.kylemanagement.mapper.CustomerMapper;
import com.kylemanagement.model.Customer;
import com.kylemanagement.model.User;
import com.kylemanagement.repository.CustomerRepository;
import com.kylemanagement.service.CustomerService;
import com.kylemanagement.service.SecurityContextService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final SecurityContextService securityContextService;

    @Override
    public CustomerApi saveCustomer(CustomerApi customerApi) {
        Customer customer = customerMapper.toCustomer(customerApi);
        User loggedUser = securityContextService.getLoggedUser();
        customer.setCreationUserId(loggedUser.getUserId());
        return customerMapper.toCustomerApi(customerRepository.save(customer));
    }

    @Override
    public List<CustomerApi> getCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toCustomerApi).toList();
    }
}
