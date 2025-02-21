package com.sel.bank.card.hexagonalarchitecture.adapterinfrastrure.output.nosql;

import java.util.List;

import com.sel.bank.card.hexagonalarchitecture.core.model.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CardRepository extends MongoRepository<Card, String>{
	
	@Query("{'Type.name':?0}")
	List<Card> findByCategory(String name);
}
