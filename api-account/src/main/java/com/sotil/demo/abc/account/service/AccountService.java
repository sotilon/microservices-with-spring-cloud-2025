package com.sotil.demo.abc.account.service;

import com.sotil.demo.abc.account.domain.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> findAll();
    Optional<Account> findById(Long accountId);
    Account save(Account account);
    void delete(Account account);
}
