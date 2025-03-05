package com.sotil.demo.abc.account.dao;

import com.sotil.demo.abc.account.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AccountDaoImpl implements AccountDao{

    @Autowired
    private AccountRepository repository;

    @Override
    public List<Account> findAll() {
        return (List<Account>) repository.findAll();
    }

    @Override
    public Optional<Account> findById(Long accountId) {
        return repository.findById(accountId);
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
