package com.labhi.stockpricehistory.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.labhi.stockprice.model.StockPrice;
import com.labhi.stockprice.model.StockPriceHistory;

@Repository
public interface StockPriceHistoryRepository extends MongoRepository<StockPriceHistory, String>{

	List<StockPrice> findAllByStockId(String stockId);

}
