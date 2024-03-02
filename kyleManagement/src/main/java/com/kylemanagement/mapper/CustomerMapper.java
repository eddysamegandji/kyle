package com.kylemanagement.mapper;

import com.api.model.CustomerDto;
import com.kylemanagement.model.Customer;
import org.mapstruct.*;


import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface CustomerMapper {

    CustomerDto toCustomerDto(Customer customer);

    @InheritInverseConfiguration
    @Mapping(target = "customerId", ignore = true)
    Customer toCustomer(CustomerDto customerDto, @MappingTarget Customer customer);

}
