package com.sel.bank.wallet.service;

import com.sel.bank.wallet.model.Wallet;

import java.util.List;
import java.util.Optional;

public interface IWalletService {
	public List<Wallet> findAll();
	public Wallet save(Wallet wallet);
	public void delete(Wallet wallet);
	public Optional<Wallet> findById(String id);
	
}
