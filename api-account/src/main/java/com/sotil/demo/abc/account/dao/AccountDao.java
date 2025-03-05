package com.sotil.demo.abc.account.dao;

import com.sotil.demo.abc.account.domain.Account;

import java.util.List;
import java.util.Optional;

public interface AccountDao {
    List<Account> findAll();
    Optional<Account> findById(Long accountId);
    Account save(Account account);
    void delete(Account account);
}
