package com.kylemanagement.mapper;

import com.api.model.CustomerApi;
import com.kylemanagement.model.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface CustomerMapper {

    @Mapping(target="customerId", source="customerId")
    @Mapping(target="firstName", source="firstName")
    @Mapping(target="lastName", source="lastName")
    @Mapping(target="fullName", source="fullName")
    @Mapping(target="birthDate", source="birthDate")
    @Mapping(target="birthCity", source="birthCity")
    @Mapping(target="birthDepartment", source="birthDepartment")
    @Mapping(target="address1", source="address1")
    @Mapping(target="address2", source="address2")
    @Mapping(target="zipCode", source="zipCode")
    @Mapping(target="city", source="city")
    @Mapping(target="country", source="country")
    @Mapping(target="mobilePhone", source="mobilePhone")
    @Mapping(target="emailAddress", source="emailAddress")
    @Mapping(target="companyName", source="companyName")
    @Mapping(target="companyPosition", source="companyPosition")
    @Mapping(target="workPhone", source="workPhone")
    CustomerApi toCustomerApi(Customer customer);

    @InheritInverseConfiguration
    Customer toCustomer(CustomerApi customerApi);


}
