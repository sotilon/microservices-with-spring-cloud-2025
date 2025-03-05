package com.sotil.demo.abc.infrastructure.port.input;

import com.sotil.demo.abc.infrastructure.adapter.persistence.mongo.colecction.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
	List<Customer> findAll();
	Optional<Customer> findById(String id);
	Customer save(Customer customer);
	void delete(Customer customer);
}
