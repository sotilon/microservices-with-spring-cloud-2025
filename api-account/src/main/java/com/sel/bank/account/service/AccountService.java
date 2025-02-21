package com.sel.bank.account.service;

import com.sel.bank.account.domain.Account;

import java.util.List;

public interface AccountService {
    public List<Account> findAll();
    public Account save(Account account);
    public void delete(Account account);
}
