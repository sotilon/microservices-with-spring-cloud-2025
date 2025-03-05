package com.sotil.demo.abc.infrastructure.port.input;

import com.sotil.demo.abc.domain.model.Account;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ICustomerFeignService {
	Account getAccountById(@PathVariable("id") Long id);

	List<Account> findAll();
}
