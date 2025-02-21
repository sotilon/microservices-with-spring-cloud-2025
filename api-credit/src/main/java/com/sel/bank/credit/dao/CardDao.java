package com.sel.bank.credit.dao;

import com.sel.bank.credit.dao.domain.Credit;

import java.util.List;
import java.util.Optional;

public interface CardDao {
    public List<Credit> findAll();
    public Optional<Credit> findById(Integer id);
    public Credit save(Credit credit);
    public void delete(Credit credit);
}
