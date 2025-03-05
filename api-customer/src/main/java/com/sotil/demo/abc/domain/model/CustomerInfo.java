package com.sotil.demo.abc.domain.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerInfo {
    private Integer id;
    private String firstName;
    private String lastName;
    private String dni;
    private String email;
    private String country;
}
