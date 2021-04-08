package com.labhi.stocktradingservice.dao;

import org.springframework.stereotype.Repository;
import com.labhi.stocktrading.model.StockTrading;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface StockTradingRepository extends  MongoRepository<StockTrading, String>{

}
