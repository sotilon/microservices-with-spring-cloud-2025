package com.sotil.demo.abc.infrastructure.adapter.persistence.mongo;

import com.sotil.demo.abc.infrastructure.adapter.persistence.mongo.colecction.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
