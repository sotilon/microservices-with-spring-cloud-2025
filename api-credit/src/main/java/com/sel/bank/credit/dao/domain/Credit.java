package com.sel.bank.credit.dao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="credit")
@AllArgsConstructor
@NoArgsConstructor
public class Credit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cardNumber;
	private String cardType;
	private String customerCode;
}
