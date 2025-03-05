package com.sotil.demo.abc.infrastructure.adapter.persistence.mongo;

import com.sotil.demo.abc.infrastructure.adapter.persistence.mongo.colecction.Customer;
import com.sotil.demo.abc.infrastructure.port.outport.IAdapterCustomerNoSql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdapterCustomerNoSqlImpl implements IAdapterCustomerNoSql {

    @Autowired
    CustomerRepository repository;


    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Customer> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        repository.delete(customer);
    }
}
