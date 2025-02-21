package com.sel.bank.transaction.hexagonal.adapter.input.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Data
public class TransactionDto {
	private String id;
	private String fromAccountNumber;
	private String toAccountNumber;
	private String typeCode;
	private String debit;
	private String credit;
	private String status;
	private String description;
	private String transactionType;
	private Integer port;
}
