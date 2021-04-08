package com.labhi.accountbalance.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.labhi.accountbalance.model.AccountBalance;

@Repository
public interface AccountBalanceRepository extends MongoRepository<AccountBalance, String>{
	
	public Optional<AccountBalance> findByCustomerId(String customerId);

}
