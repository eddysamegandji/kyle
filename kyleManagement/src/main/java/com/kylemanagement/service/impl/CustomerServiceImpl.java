package com.kylemanagement.service.impl;

import com.api.model.CustomerDto;
import com.kylemanagement.mapper.CustomerMapper;
import com.kylemanagement.model.Customer;
import com.kylemanagement.model.User;
import com.kylemanagement.repository.CustomerRepository;
import com.kylemanagement.service.CustomerService;
import com.kylemanagement.service.SecurityContextService;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    final UserDetailsService userDetailsService;
    private final CustomerMapper customerMapper;
    private final SecurityContextService securityContextService;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.toCustomer(customerDto, new Customer());
//        User loggedUser = securityContextService.getLoggedUser();
        customer.setCreationUser((User) userDetailsService.loadUserByUsername("admin"));
        customer.setCreationDate(Instant.now());
        customer.setLastModifiedDate(Instant.now());
        customer.setUpdateUser((User) userDetailsService.loadUserByUsername("admin"));
        return customerMapper.toCustomerDto(customerRepository.save(customer));
    }

    @Override
    public CustomerDto updateCustomer(Long customerId, CustomerDto customerDto) {
        Optional<Customer> existingCustomer = customerRepository.findById(customerId);
        if (existingCustomer.isPresent()) {
            Customer toUpdate = customerMapper.toCustomer(customerDto, existingCustomer.get());
            toUpdate.setLastModifiedDate(Instant.now());
            toUpdate.setUpdateUser((User) userDetailsService.loadUserByUsername("admin"));
            return customerMapper.toCustomerDto(customerRepository.save(toUpdate));
        }
        return null;
    }

    @Override
    public List<CustomerDto> getCustomers() {
        return customerRepository.findAll().stream()
                .filter(c -> c.getDeleteDate() == null)
                .map(customerMapper::toCustomerDto).toList();
    }

    @Override
    public CustomerDto findCustomerById(Long id) {
       return customerRepository.findById(id)
               .map(customerMapper::toCustomerDto)
               .orElse(null);
    }

    @Override
    public void deleteCustomerById(Long id) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            existingCustomer.get().setDeleteDate(Instant.now());
            existingCustomer.get().setDeleteUser((User) userDetailsService.loadUserByUsername("admin"));
            customerRepository.save(existingCustomer.get());
        }
    }
}
