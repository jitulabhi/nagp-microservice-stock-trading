package com.labhi.cqrs.event;

public class DepositEvent {
	
	public String customerId;
	public double amount;
	
	public DepositEvent(String customerId, double amount) {
		this.customerId = customerId;
		this.amount = amount;
	}

}
