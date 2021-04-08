package com.labhi.stockholdingsnapshot.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.labhi.stocktrading.model.StockHolding;

@Repository
public interface StockHoldingSnapshotRepository extends MongoRepository<StockHolding, String>{

	List<StockHolding> findAllByCustomerId(String customerId);

}
