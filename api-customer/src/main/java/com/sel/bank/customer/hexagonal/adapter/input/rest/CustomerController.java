package com.sel.bank.customer.hexagonal.adapter.input.rest;

import com.sel.bank.customer.hexagonal.adapter.input.dto.CustomerDto;
import com.sel.bank.customer.hexagonal.adapter.input.dto.CustomerMapper;
import com.sel.bank.customer.hexagonal.adapter.output.database.colecction.Customer;
import com.sel.bank.customer.hexagonal.port.input.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService service;

	@Autowired
	private Environment env;

	@GetMapping("/list")
	public List<CustomerDto> findAll(){
		List<CustomerDto> dtoList = new ArrayList();
		List<Customer> list = service.findAll();
		list.stream().forEach(customer -> {
			CustomerDto dto = CustomerMapper.INSTANCE.customerDtoToCustomer(customer);
			//dto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			dtoList.add(dto);
		});
		return dtoList;
	}
	
	@GetMapping("/{id}")
	public Optional<CustomerDto> findById(@PathVariable String id){
		Optional<Customer> customer = service.findById(id);
		if(customer.isPresent()){
			CustomerDto dto = CustomerMapper.INSTANCE.customerDtoToCustomer(customer.get());
			return Optional.of(dto);
		}
		return Optional.empty();
	}
	
	@PostMapping("/save")
	public CustomerDto save(@RequestBody CustomerDto dto) {
		Customer customer = CustomerMapper.INSTANCE.customerToCustomer(dto);
		service.save(customer);
		return dto;
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody CustomerDto dto) {
		Customer customer = CustomerMapper.INSTANCE.customerToCustomer(dto);
		service.delete(customer);
	}
}
