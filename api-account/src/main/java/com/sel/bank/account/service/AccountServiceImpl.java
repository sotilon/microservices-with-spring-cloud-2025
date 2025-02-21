package com.sel.bank.account.service;

import com.sel.bank.account.dao.AccountDao;
import com.sel.bank.account.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao dao;


    @Override
    public List<Account> findAll() {
        return dao.findAll();
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
