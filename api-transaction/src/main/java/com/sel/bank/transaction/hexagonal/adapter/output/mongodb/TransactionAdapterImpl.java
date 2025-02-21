package com.sel.bank.transaction.hexagonal.adapter.output.mongodb;

import com.sel.bank.transaction.hexagonal.adapter.output.collection.Transaction;
import com.sel.bank.transaction.hexagonal.port.output.ITransactionAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TransactionAdapterImpl implements ITransactionAdapter {
    @Autowired
    private TransactionRepository repository;

    @Override
    public List<Transaction> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Transaction> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Transaction save(Transaction transaction) {
        return repository.save(transaction);
    }

    @Override
    public void delete(Transaction transaction) {
        repository.delete(transaction);
    }
}
