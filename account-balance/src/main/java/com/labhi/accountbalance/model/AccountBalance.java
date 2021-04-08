package com.labhi.accountbalance.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "account-balance-snapshot")
public class AccountBalance {
	
	@Id
	public ObjectId id;
	public String customerId;
	public double balance;

}
