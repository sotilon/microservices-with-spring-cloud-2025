package com.sotil.demo.abc.account.service;

import com.sotil.demo.abc.account.dao.AccountDao;
import com.sotil.demo.abc.account.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao dao;


    @Override
    public List<Account> findAll() {
        return dao.findAll();
    }

    @Override
    public Optional<Account> findById(Long accountId) {
        return dao.findById(accountId);
    }

    @Override
    public Account save(Account account) {
        return dao.save(account);
    }

    @Override
    public void delete(Account account) {
        dao.delete(account);
    }
}
