package com.sel.bank.credit.service;

import com.sel.bank.credit.dao.CardDao;
import com.sel.bank.credit.dao.domain.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditServiceImpl implements ICreditService {

	@Autowired
	CardDao cardDao;


	@Override
	public List<Credit> findAll() {
		return cardDao.findAll();
	}

	@Override
	public Optional<Credit> findById(Integer id) {
		return cardDao.findById(id);
	}

	@Override
	public Credit save(Credit credit) {
		return cardDao.save(credit);
	}

	@Override
	public void delete(Credit credit) {
		cardDao.delete(credit);
	}
}
