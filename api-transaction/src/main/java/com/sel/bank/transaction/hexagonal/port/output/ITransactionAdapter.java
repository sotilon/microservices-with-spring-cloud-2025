package com.sel.bank.transaction.hexagonal.port.output;

import com.sel.bank.transaction.hexagonal.adapter.output.collection.Transaction;

import java.util.List;
import java.util.Optional;

public interface ITransactionAdapter {
    public List<Transaction> findAll();
    public Optional<Transaction> findById(String id);
    public Transaction save(Transaction transaction);
    public void delete(Transaction transaction);

}
