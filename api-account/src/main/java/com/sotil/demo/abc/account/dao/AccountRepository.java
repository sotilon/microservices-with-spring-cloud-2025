package com.sotil.demo.abc.account.dao;

import com.sotil.demo.abc.account.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
