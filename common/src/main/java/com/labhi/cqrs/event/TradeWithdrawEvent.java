package com.labhi.cqrs.event;

public class TradeWithdrawEvent {

	 public String transactionId;
	
	public String tradeId;
	
	public String customerId;
	
	public double amount;

	public TradeWithdrawEvent(String transactionId, String tradeId, String customerId, double amount) {
		this.transactionId = transactionId;
		this.tradeId = tradeId;
		this.customerId = customerId;
		this.amount = amount;
	}
}
