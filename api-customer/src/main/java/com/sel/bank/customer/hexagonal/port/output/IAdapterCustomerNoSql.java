package com.sel.bank.customer.hexagonal.port.output;

import com.sel.bank.customer.hexagonal.adapter.output.database.colecction.Customer;

import java.util.List;
import java.util.Optional;

public interface IAdapterCustomerNoSql {
    public List<Customer> findAll();
    public Optional<Customer> findById(String id);
    public Customer save(Customer customer);
    public void delete(Customer customer);

}
