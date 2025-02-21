package com.sel.bank.card.hexagonalarchitecture.applicationport.outputport;

import com.sel.bank.card.hexagonalarchitecture.core.model.Card;

import java.util.List;
import java.util.Optional;

public interface IAdapterFacade {
    public List<Card> findAll();
    public Optional<Card> findById(String id);
    public Card save(Card card);
    public void delete(Card card);
}
