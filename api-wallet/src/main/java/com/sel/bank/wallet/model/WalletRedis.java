package com.sel.bank.wallet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletRedis implements Serializable {
	private Integer id;
	private String account;
	private Double mount;
	private String description;
	
}
