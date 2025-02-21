package com.sel.bank.credit.dao;

import com.sel.bank.credit.dao.domain.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CardDaoImpl implements CardDao{
    @Autowired
    CreditRepository repository;

    @Override
    public List<Credit> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Credit> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Credit save(Credit credit) {
        return repository.save(credit);
    }

    @Override
    public void delete(Credit credit) {
        repository.delete(credit);
    }
}
