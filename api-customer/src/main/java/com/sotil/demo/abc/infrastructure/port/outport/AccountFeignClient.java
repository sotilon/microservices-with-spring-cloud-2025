package com.sotil.demo.abc.infrastructure.port.outport;

import com.sotil.demo.abc.domain.model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(name = "api-account", url = "http://localhost:8003") // Replace with actual service URL
@FeignClient(name = "api-account")
public interface AccountFeignClient {

    @GetMapping("/api/v1/accounts")
    List<Account> findAll();

    @GetMapping("/api/v1/account/{id}")
    Account getAccountById(@PathVariable("id") Long id);

}
