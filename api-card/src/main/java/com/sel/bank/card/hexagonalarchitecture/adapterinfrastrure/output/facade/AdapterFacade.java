package com.sel.bank.card.hexagonalarchitecture.adapterinfrastrure.output.facade;

import com.sel.bank.card.hexagonalarchitecture.applicationport.outputport.IAdapterCardNoSql;
import com.sel.bank.card.hexagonalarchitecture.core.model.Card;
import com.sel.bank.card.hexagonalarchitecture.applicationport.outputport.IAdapterFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AdapterFacade implements IAdapterFacade {

    @Autowired
    private IAdapterCardNoSql mongodb;


    @Override
    public List<Card> findAll() {
        return mongodb.findAll();
    }

    @Override
    public Optional<Card> findById(String id) {
        return mongodb.findById(id);
    }

    @Override
    public Card save(Card card) {
        return mongodb.save(card);
    }

    @Override
    public void delete(Card card) {
        mongodb.delete(card);
    }
}
