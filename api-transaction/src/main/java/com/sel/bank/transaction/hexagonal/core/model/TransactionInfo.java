package com.sel.bank.transaction.hexagonal.core.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionInfo {
    private String transactionId;
    private String fromAccountNumber;
    private String toAccountNumber;
    private String typeCode;
    private String debit;
    private String credit;
    private String status;
    private String description;
    private String transactionType;
}
