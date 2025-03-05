package com.sotil.demo.abc.account.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Matches SERIAL in PostgreSQL
	private Long id;

	@Column(name = "accountnumber", length = 50, nullable = false) // Matches VARCHAR(50) NOT NULL
	private String accountNumber;

	@Column(name = "minimumbalance", precision = 10, scale = 2) // Matches NUMERIC(10,2)
	private BigDecimal minimumBalance;

	@Column(name = "currentbalance", precision = 10, scale = 2) // Matches NUMERIC(10,2)
	private BigDecimal currentBalance;

	@Column(name = "interestrate", precision = 5, scale = 2) // Matches NUMERIC(5,2)
	private BigDecimal interestRate;

}
