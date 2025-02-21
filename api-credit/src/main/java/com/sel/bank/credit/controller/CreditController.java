package com.sel.bank.credit.controller;

import com.sel.bank.credit.dao.domain.Credit;
import com.sel.bank.credit.dto.CreditDto;
import com.sel.bank.credit.service.ICreditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/credit")
public class CreditController {
	
	@Autowired
	private ICreditService service;

	@GetMapping("/list")
	public List<CreditDto> findAll(){
		return service.findAll().stream().map(credit -> {
			CreditDto dto = new CreditDto();
			dto.setCardNumber(credit.getCardNumber());
			dto.setCardType(credit.getCardType());
			dto.setCustomerCode(credit.getCustomerCode());
			dto.setId(credit.getId());
			return dto;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public Optional<CreditDto> findById(@PathVariable Integer id){
		Optional<Credit> credits = service.findById(id);
		if(credits.isPresent()){
			Credit credit = credits.get();
			CreditDto dto = new CreditDto();
			dto.setCardNumber(credit.getCardNumber());
			dto.setCardType(credit.getCardType());
			dto.setCustomerCode(credit.getCustomerCode());
			dto.setId(credit.getId());
			return Optional.of(dto);
		}
		return Optional.empty();
	}
	
	@PostMapping("/save")
	public CreditDto save(@RequestBody CreditDto dto) {
		log.info(dto.toString());
		Credit credit = new Credit();
		credit.setCardNumber(dto.getCardNumber());
		credit.setCardType(dto.getCardType());
		credit.setCustomerCode(dto.getCustomerCode());
		credit = service.save(credit);
		dto.setId(credit.getId());
		return dto;
	}
}