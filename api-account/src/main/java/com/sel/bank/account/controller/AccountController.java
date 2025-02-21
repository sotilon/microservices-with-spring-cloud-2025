package com.sel.bank.account.controller;

import com.sel.bank.account.domain.Account;
import com.sel.bank.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService service;

	@Autowired
	private Environment env;
	
	@GetMapping("/list")
	public List<Account> findAll(){
		return service.findAll();
	}

	@PostMapping("/save")
	public Account save(@RequestBody Account account){
		return service.save(account);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody Account account) {
		service.delete(account);
	}
}
