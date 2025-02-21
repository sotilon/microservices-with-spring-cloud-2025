package com.sel.bank.credit.dao;

import com.sel.bank.credit.dao.domain.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Integer>{

}
