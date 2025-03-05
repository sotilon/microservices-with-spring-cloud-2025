package com.sotil.demo.abc.infrastructure.port.outport;

import com.sotil.demo.abc.domain.model.Account;

import java.util.List;

public interface IAccountService {

    void saveAccount(Account account);

    Account getAccountById(Long id);

    List<Account> getAllAccounts();

}
