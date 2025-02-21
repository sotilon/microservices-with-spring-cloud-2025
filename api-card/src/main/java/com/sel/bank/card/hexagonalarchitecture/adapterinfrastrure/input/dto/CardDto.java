package com.sel.bank.card.hexagonalarchitecture.adapterinfrastrure.input.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class CardDto {
    private String id;
    private String cardNumber;
    private String bankName;
    private String cardHolderName;
    private String cvvCode;
    private Date expirationDate;
    private String cardType;
    private Integer port;


}
