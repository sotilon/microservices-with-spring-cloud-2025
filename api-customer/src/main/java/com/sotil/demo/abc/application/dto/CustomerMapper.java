package com.sotil.demo.abc.application.dto;

import com.sotil.demo.abc.infrastructure.adapter.persistence.mongo.colecction.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    // Ensure "code" exists in CustomerDto
    @Mapping(source = "code", target = "dni")
    Customer customerDtoToCustomer(CustomerDto dto);

    // Ensure "dni" exists in Customer
    @Mapping(source = "dni", target = "code")
    CustomerDto customerToCustomerDto(Customer customer);
}