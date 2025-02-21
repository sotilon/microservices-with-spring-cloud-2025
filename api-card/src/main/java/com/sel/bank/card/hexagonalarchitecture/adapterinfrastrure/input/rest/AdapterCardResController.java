package com.sel.bank.card.hexagonalarchitecture.adapterinfrastrure.input.rest;

import com.sel.bank.card.hexagonalarchitecture.core.model.Card;
import com.sel.bank.card.hexagonalarchitecture.applicationport.inputport.ICardServiceUC;
import com.sel.bank.card.hexagonalarchitecture.adapterinfrastrure.input.dto.CardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/card")
public class AdapterCardResController {
	
	@Autowired
	private ICardServiceUC service;

	@Autowired
	private Environment env;
	
	@GetMapping("/list")
	public List<CardDto> findAll(){
		List<CardDto> cardDtoList = new ArrayList();
		List<Card> cards = service.findAll();
		cards.stream().forEach(card -> {
			CardDto cardDto = new CardDto();
			cardDto.setId(card.getId());
			cardDto.setCardNumber(card.getCardNumber());
			cardDto.setBankName(card.getBankName());
			cardDto.setCardHolderName(card.getCardHolderName());
			cardDto.setCardType(card.getCardType());
			cardDto.setCvvCode(String.valueOf(card.getCvvCode()));
			cardDto.setExpirationDate(card.getExpirationDate());
			cardDto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			cardDtoList.add(cardDto);
		});
		return cardDtoList;
	}
	
	@GetMapping("{id}")
	public Optional<CardDto> findById(@PathVariable String id){
		Optional<Card> cardDB = service.findById(id);
		if(cardDB.isPresent()){
			Card card  = cardDB.get();
			CardDto cardDto = new CardDto();
			cardDto.setId(card.getId());
			cardDto.setCardNumber(card.getCardNumber());
			cardDto.setBankName(card.getBankName());
			cardDto.setCardHolderName(card.getCardHolderName());
			cardDto.setCardType(card.getCardType());
			cardDto.setCvvCode(String.valueOf(card.getCvvCode()));
			cardDto.setExpirationDate(card.getExpirationDate());
			cardDto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return Optional.of(cardDto);
		}
		return Optional.of(new CardDto());
	}

	@PostMapping("/save")
	public Card save(@RequestBody CardDto cardDto){
		Card card  = new Card();
		card.setId(cardDto.getId());
		card.setCardNumber(cardDto.getCardNumber());
		card.setBankName(cardDto.getBankName());
		card.setCardHolderName(cardDto.getCardHolderName());
		card.setCardType(cardDto.getCardType());
		card.setCvvCode(Integer.valueOf(cardDto.getCvvCode()));
		card.setExpirationDate(cardDto.getExpirationDate());
		return service.save(card);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody CardDto cardDto) {
		Card card  = new Card();
		card.setId(cardDto.getId());
		card.setCardNumber(cardDto.getCardNumber());
		card.setBankName(cardDto.getBankName());
		card.setCardHolderName(cardDto.getCardHolderName());
		card.setCardType(cardDto.getCardType());
		card.setCvvCode(Integer.valueOf(cardDto.getCvvCode()));
		card.setExpirationDate(cardDto.getExpirationDate());
		service.delete(card);
	}
}
