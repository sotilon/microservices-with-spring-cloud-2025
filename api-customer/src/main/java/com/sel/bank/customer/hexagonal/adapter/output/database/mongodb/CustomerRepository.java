package com.sel.bank.customer.hexagonal.adapter.output.database.mongodb;

import com.sel.bank.customer.hexagonal.adapter.output.database.colecction.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
