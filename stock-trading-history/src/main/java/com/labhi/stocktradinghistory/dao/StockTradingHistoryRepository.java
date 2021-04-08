package com.labhi.stocktradinghistory.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.labhi.stocktrading.model.StockTrading;

@Repository
public interface StockTradingHistoryRepository  extends MongoRepository<StockTrading, String>{

	List<StockTrading> findAllByCustomerId(String customerId);
}
