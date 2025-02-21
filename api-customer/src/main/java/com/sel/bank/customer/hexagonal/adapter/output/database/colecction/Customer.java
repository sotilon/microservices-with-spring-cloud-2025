package com.sel.bank.customer.hexagonal.adapter.output.database.colecction;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer")
public class Customer {
	@MongoId
	private String id;
	private String firstName;
	private String lastName;
	private String dni;
	private String email;
	private LocalDate createDate;
}