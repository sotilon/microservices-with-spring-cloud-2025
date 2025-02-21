package com.sel.bank.transaction.hexagonal.port.input;

import com.sel.bank.transaction.hexagonal.adapter.output.collection.Transaction;

import java.util.List;
import java.util.Optional;

public interface ITransactionService {
	public List<Transaction> findAll();
	public Optional<Transaction> findById(String id);
	public Transaction save(Transaction transaction);
	public void delete(Transaction transaction);
}
