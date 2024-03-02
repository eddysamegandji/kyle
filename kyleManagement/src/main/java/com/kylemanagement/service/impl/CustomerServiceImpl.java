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
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.toCustomer(customerDto);
//        User loggedUser = securityContextService.getLoggedUser();
        customer.setCreationUser((User) userDetailsService.loadUserByUsername("admin"));
        customer.setCreationDate(Instant.now());
        customer.setLastModifiedDate(Instant.now());
        customer.setUpdateUser((User) userDetailsService.loadUserByUsername("admin"));
        return customerMapper.toCustomerDto(customerRepository.save(customer));
    }

    @Override
    public Customer updateCustomer(Long customerId, CustomerDto customerDto) {
        Optional<Customer> existingCustomer = customerRepository.findById(customerId);
        if (existingCustomer.isPresent()) {
            Customer toUpdate = existingCustomer.get();
            toUpdate.setTitle(customerDto.getTitle());
            toUpdate.setFirstName(customerDto.getFirstName());
            toUpdate.setLastName(customerDto.getLastName());
            toUpdate.setBirthDate(customerDto.getBirthDate());
            toUpdate.setBirthCity(customerDto.getBirthCity());
            toUpdate.setBirthDepartment(customerDto.getBirthDepartment());
            toUpdate.setAddress1(customerDto.getAddress1());
            toUpdate.setAddress2(customerDto.getAddress2());
            toUpdate.setZipCode(customerDto.getZipCode());
            toUpdate.setCity(customerDto.getCity());
            toUpdate.setCountry(customerDto.getCountry());
            toUpdate.setMobilePhone(customerDto.getMobilePhone());
            toUpdate.setEmailAddress(customerDto.getEmailAddress());
            toUpdate.setEmailAddress2(customerDto.getEmailAddress2());
            toUpdate.setCompanyName(customerDto.getCompanyName());
            toUpdate.setCompanyPosition(customerDto.getCompanyPosition());
            toUpdate.setWorkPhone(customerDto.getWorkPhone());
            toUpdate.setKbis(customerDto.getKbis());
            toUpdate.setFax(customerDto.getFax());
            toUpdate.setVip(customerDto.getVip());
            toUpdate.setUpdateUser((User) userDetailsService.loadUserByUsername("admin"));
            toUpdate.setLastModifiedDate(Instant.now());
            return customerRepository.save(toUpdate);
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
