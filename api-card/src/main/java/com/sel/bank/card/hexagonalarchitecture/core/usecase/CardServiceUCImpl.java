package com.sel.bank.card.hexagonalarchitecture.core.usecase;

import java.util.List;
import java.util.Optional;

import com.sel.bank.card.hexagonalarchitecture.applicationport.inputport.ICardServiceUC;
import com.sel.bank.card.hexagonalarchitecture.applicationport.outputport.IAdapterFacade;
import com.sel.bank.card.hexagonalarchitecture.core.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceUCImpl implements ICardServiceUC {
	
	@Autowired
	private IAdapterFacade facade;

	@Override
	public List<Card> findAll() {
		return facade.findAll();
	}

	@Override
	public Optional<Card> findById(String id) {
		return facade.findById(id);
	}

	@Override
	public Card save(Card card) {
		return facade.save(card);
	}

	@Override
	public void delete(Card card) {
		facade.delete(card);
	}


}
