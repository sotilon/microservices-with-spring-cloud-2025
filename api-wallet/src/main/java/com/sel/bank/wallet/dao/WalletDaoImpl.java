package com.sel.bank.wallet.dao;

import com.sel.bank.wallet.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class WalletDaoImpl implements WalletDao{

    @Autowired
    private WalletRepository repository;

    @Override
    public List<Wallet> findAll() {
        return repository.findAll();
    }

    @Override
    public Wallet save(Wallet wallet) {
        return repository.save(wallet);
    }

    @Override
    public void delete(Wallet wallet) {
        repository.delete(wallet);
    }

    @Override
    public Optional<Wallet> findById(String id) {
        return repository.findById(Integer.valueOf(id));
    }
}
