package com.sotil.demo.abc.application.usecases;

import com.sotil.demo.abc.domain.model.Account;
import com.sotil.demo.abc.infrastructure.port.input.ICustomerFeignService;
import com.sotil.demo.abc.infrastructure.port.outport.AccountFeignClient;
import com.sotil.demo.abc.infrastructure.port.outport.IAccountService;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

@Log4j2
@Service
public class CustomerFeignService implements ICustomerFeignService {

	@Autowired
	private AccountFeignClient accountFeignClient;

	@Autowired
	private IAccountService  iAccountService;

	@Autowired
	private CircuitBreakerFactory circuitBreakerFactory;

	@Autowired
	private CircuitBreakerRegistry circuitBreakerRegistry;


	public void openCircuitBreaker() {
		circuitBreakerRegistry.circuitBreaker("accountServiceCircuitBreakerById").transitionToOpenState();
	}

	@Override
	public List<Account> findAll() {
		return circuitBreakerFactory.create("accountServiceCircuitBreaker")
				.run(() -> {
					log.info("Fetching accounts using Feign client...");
					List<Account> accounts = accountFeignClient.findAll();
					if (!CollectionUtils.isEmpty(accounts)) {
						accounts.forEach(account -> {
							log.info("Saving Account in Redis :: {}", account);
							iAccountService.saveAccount(account);
						});
					}
					return accounts;
				}, throwable -> fallbackMethod(throwable));
	}

	// Fallback method when Feign client fails
	public List<Account> fallbackMethod(Throwable throwable) {
		log.error("Fallback triggered due to: {}", throwable.getMessage());
		List<Account> accountList = iAccountService.getAllAccounts();
		accountList.forEach(account -> {
			log.info(" get data  from  redis :: {}",account);
		});
		return accountList;
	}


	@CircuitBreaker(name = "accountServiceCircuitBreakerById", fallbackMethod = "fallbackMethodById")
	@Override
	public Account getAccountById(Long id) {
		log.info(" get Account from api-account using feign , id ::{}",id);
		return accountFeignClient.getAccountById(id);
	}


	public Account fallbackMethodById(Long id, Throwable throwable) {
		log.error("Fallback triggered for getAccountById({}) due to: {}", id, throwable.getMessage());
		Account  account = iAccountService.getAccountById(id);
		log.info(" method fallbackMethodById from Redis :: {}",account);
		return account;
	}

}
