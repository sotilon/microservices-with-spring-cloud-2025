package com.sel.bank.wallet.dao;

import com.sel.bank.wallet.model.Wallet;
import com.sel.bank.wallet.model.WalletRedis;

import java.util.List;
import java.util.Optional;

public interface WalletRepoRedis {
    public List<WalletRedis> findAll();
    public WalletRedis save(WalletRedis wallet);
    public void delete(WalletRedis wallet);
    public Optional<WalletRedis> findById(String id);
}
