package com.sotil.demo.abc.infrastructure.adapter.rest;

import com.sotil.demo.abc.application.dto.CustomerDto;
import com.sotil.demo.abc.application.dto.CustomerMapper;
import com.sotil.demo.abc.infrastructure.adapter.persistence.mongo.colecction.Customer;
import com.sotil.demo.abc.domain.model.Account;
import com.sotil.demo.abc.infrastructure.port.input.ICustomerFeignService;
import com.sotil.demo.abc.infrastructure.port.input.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService service;

	@Autowired
	private ICustomerFeignService iCustomerFeignService;

	@Autowired
	private Environment env;

	@GetMapping("/list")
	public List<CustomerDto> findAll(){
		List<CustomerDto> dtoList = new ArrayList();
		List<Customer> list = service.findAll();
		list.stream().forEach(customer -> {
			CustomerDto dto = CustomerMapper.INSTANCE.customerToCustomerDto(customer);
			//dto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			dtoList.add(dto);
		});
		return dtoList;
	}
	
	@GetMapping("/{id}")
	public Optional<CustomerDto> findById(@PathVariable String id){
		Optional<Customer> customer = service.findById(id);
		if(customer.isPresent()){
			CustomerDto dto = CustomerMapper.INSTANCE.customerToCustomerDto(customer.get());
			return Optional.of(dto);
		}
		return Optional.empty();
	}
	
	@PostMapping("/save")
	public CustomerDto save(@RequestBody CustomerDto dto) {
		System.out.println("dto:" +dto.toString());
		Customer customer = CustomerMapper.INSTANCE.customerDtoToCustomer(dto);
		service.save(customer);
		return dto;
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody CustomerDto dto) {
		Customer customer = CustomerMapper.INSTANCE.customerDtoToCustomer(dto);
		service.delete(customer);
	}

	@GetMapping("/accounts")
	public List<Account> findAccountAll(){
		return iCustomerFeignService.findAll();
	}

	@GetMapping("/account/{id}")
	public Account getAccountById(@PathVariable(value = "id") Long id){
		return iCustomerFeignService.getAccountById(id);
	}

}
