package com.sel.bank.customer.hexagonal.adapter.input.dto;

import com.sel.bank.customer.hexagonal.adapter.output.database.colecction.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );

    @Mapping(source = "code", target = "dni")
    Customer customerToCustomer(CustomerDto dto);

    @Mapping(source = "dni", target = "code")
    CustomerDto customerDtoToCustomer(Customer dto);

}
