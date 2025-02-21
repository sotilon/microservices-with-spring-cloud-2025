package com.sel.bank.account.dao;

import com.sel.bank.account.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
