package com.sel.bank.transaction.hexagonal.adapter.output.collection;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "transaction")
public class Transaction {
	@MongoId
	private String id;
	private String fromAccountNumber;
	private String toAccountNumber;
	private String typeCode;
	private String debit;
	private String credit;
	private String status;
	private String description;
	private String transactionType;
	private Date dateTime;
}
