package com.labhi.accountbalance.dao;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.labhi.bankaccount.model.BankAccount;

@Repository
public interface BankAccountRepository  extends MongoRepository<BankAccount,String>{

	 List<BankAccount> findAllByCustomerId(String customerId);

}
