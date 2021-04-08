package com.labhi.bankaccount.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.labhi.bankaccount.model.BankAccount;

@Repository
public interface BankAccountRepository  extends MongoRepository<BankAccount,String>{

}
