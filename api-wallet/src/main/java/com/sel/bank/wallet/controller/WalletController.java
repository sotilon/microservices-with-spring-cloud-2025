package com.sel.bank.wallet.controller;

import com.sel.bank.wallet.model.Wallet;
import com.sel.bank.wallet.service.IWalletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/wallet")
@Slf4j
public class WalletController {

	@Autowired
	private IWalletService service;

	@GetMapping("/list")
	public List<Wallet> list() {
		return service.findAll();
	}

	@PostMapping("/save")
	public Wallet save(@RequestBody Wallet dto) {
		log.info(dto.toString());
		Wallet wallet = service.save(dto);
		return wallet;
	}

	@GetMapping("{id}")
	public Optional<Wallet> findById(@PathVariable String id){
		return service.findById(id);
	}
}