package com.sel.bank.wallet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="wallet")
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String account;
	private Double mount;
	private String description;
	
}
