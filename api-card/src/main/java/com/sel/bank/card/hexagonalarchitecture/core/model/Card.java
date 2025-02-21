package com.sel.bank.card.hexagonalarchitecture.core.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "card")
public class Card {
	@MongoId
	private String id;
	private String cardNumber;
	private String bankName;
	private String cardHolderName;
	private Integer cvvCode;
	private Date expirationDate;
	private String cardType;
}
