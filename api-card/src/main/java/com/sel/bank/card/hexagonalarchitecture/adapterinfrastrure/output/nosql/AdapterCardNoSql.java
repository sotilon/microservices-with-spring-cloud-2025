package com.sel.bank.card.hexagonalarchitecture.adapterinfrastrure.output.nosql;

import com.sel.bank.card.hexagonalarchitecture.core.model.Card;
import com.sel.bank.card.hexagonalarchitecture.applicationport.outputport.IAdapterCardNoSql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdapterCardNoSql implements IAdapterCardNoSql {

    @Autowired
    private CardRepository repository;

    @Override
    public List<Card> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Card> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Card save(Card card) {
        return repository.save(card);
    }

    @Override
    public void delete(Card card) {
        repository.delete(card);
    }
}
