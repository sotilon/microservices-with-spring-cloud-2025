package com.sel.bank.customer.hexagonal.core.usecase;

import com.sel.bank.customer.hexagonal.adapter.output.database.colecction.Customer;
import com.sel.bank.customer.hexagonal.port.input.ICustomerService;
import com.sel.bank.customer.hexagonal.port.output.IAdapterCustomerNoSql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private IAdapterCustomerNoSql noSql;


	@Override
	public List<Customer> findAll() {
		return noSql.findAll();
	}

	@Override
	public Optional<Customer> findById(String id) {
		return noSql.findById(id);
	}

	@Override
	public Customer save(Customer customer) {
		return noSql.save(customer);
	}

	@Override
	public void delete(Customer customer) {
		noSql.delete(customer);
	}
}
