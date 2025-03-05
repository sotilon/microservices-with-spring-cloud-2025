package com.sotil.demo.abc.account.controller;

import com.sotil.demo.abc.account.domain.Account;
import com.sotil.demo.abc.account.service.AccountService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
	
	@Autowired
	private AccountService service;

	@Autowired
	private Environment env;

	@GetMapping("/info")
	public ResponseEntity<String> getAccountInfo() {
		return ResponseEntity.ok("Información de la cuenta");
	}

	@Cacheable(cacheNames = "accountsCache")  // Uses the "myCache" cache
	@GetMapping("/accounts")
	public List<Account> findAll(){
		log.info("::: findAll::: accounts ::: {}", Date::new);
		return service.findAll();
	}

	@Cacheable(value = "accountByIdCache", key = "#accountId")  // Cache using accountId as the key
	@GetMapping("/account/{accountId}")
	public Optional<Account> findById(@PathVariable(value ="accountId") Long accountId){
		log.info("::: findById::: accounts ::: {}", Date::new);
		return service.findById(accountId);
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
