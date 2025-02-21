package com.sel.bank.transaction.hexagonal.core.usecase;

import java.util.List;
import java.util.Optional;

import com.sel.bank.transaction.hexagonal.port.input.ITransactionService;
import com.sel.bank.transaction.hexagonal.adapter.output.collection.Transaction;
import com.sel.bank.transaction.hexagonal.port.output.ITransactionAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	private ITransactionAdapter adapter;

	@Override
	public List<Transaction> findAll() {
		return adapter.findAll();
	}

	@Override
	public Optional<Transaction> findById(String id) {
		return adapter.findById(id);
	}

	@Override
	public Transaction save(Transaction transaction) {
		return adapter.save(transaction);
	}

	@Override
	public void delete(Transaction transaction) {
		adapter.delete(transaction);
	}


}
