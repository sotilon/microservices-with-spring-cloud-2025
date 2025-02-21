package com.sel.bank.customer.hexagonal.adapter.input.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerDto {
    private String id;
    private String firstName;
    private String lastName;
    private String code;
    private String email;

}
