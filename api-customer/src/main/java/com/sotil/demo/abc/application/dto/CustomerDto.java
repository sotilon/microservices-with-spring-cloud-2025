package com.sotil.demo.abc.application.dto;

import lombok.Getter;
import lombok.Setter;


public record CustomerDto (
         String id,
         String firstName,
         String lastName,
         String code,
         String email
){


}
