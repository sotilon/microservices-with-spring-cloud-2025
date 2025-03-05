package com.sotil.demo.abc.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {
	private Long id;
	private String accountNumber;
	private BigDecimal minimumBalance;
	private BigDecimal currentBalance;
	private BigDecimal interestRate;
}
