package com.sel.bank.account.dao;

import com.sel.bank.account.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao{

    @Autowired
    private AccountRepository repository;

    @Override
    public List<Account> findAll() {
        return (List<Account>) repository.findAll();
    }

    @Override
    public Account save(Account account) {
        return repository.save(account);
    }

    @Override
    public void delete(Account account) {
        repository.delete(account);
    }

}
