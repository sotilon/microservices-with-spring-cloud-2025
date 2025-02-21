package com.sel.bank.transaction.hexagonal.adapter.output.mongodb;

import com.sel.bank.transaction.hexagonal.adapter.output.collection.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, String>{

}
