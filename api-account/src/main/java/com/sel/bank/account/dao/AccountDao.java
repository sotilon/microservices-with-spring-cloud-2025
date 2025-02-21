package com.sel.bank.account.dao;

import com.sel.bank.account.domain.Account;

import java.util.List;

public interface AccountDao {
    public List<Account> findAll();
    public Account save(Account account);
    public void delete(Account account);

}
