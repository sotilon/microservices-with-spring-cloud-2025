package com.sel.bank.credit.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreditDto {
	private Integer id;
	private String cardNumber;
	private String cardType;
	private String customerCode;
}
