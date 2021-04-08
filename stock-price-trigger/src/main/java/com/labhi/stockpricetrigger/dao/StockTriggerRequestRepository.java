package com.labhi.stockpricetrigger.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.labhi.stockpricetrigger.model.StockTriggerRequest;

@Repository
public interface StockTriggerRequestRepository extends MongoRepository<StockTriggerRequest, String>{

}
