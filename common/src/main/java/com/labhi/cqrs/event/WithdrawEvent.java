package com.labhi.cqrs.event;

public class WithdrawEvent {
	
	public String customerId;
	public double amount;
	
	public WithdrawEvent(String customerId, double amount) {
		this.customerId = customerId;
		this.amount = amount;
	}
}
