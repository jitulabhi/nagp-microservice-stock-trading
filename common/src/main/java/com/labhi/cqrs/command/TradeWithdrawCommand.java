package com.labhi.cqrs.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class TradeWithdrawCommand {

	@TargetAggregateIdentifier
	 public String transactionId;
	
	public String tradeId;
	
	public String customerId;
	
	public double amount;

	public TradeWithdrawCommand(String transactionId, String tradeId, String customerId, double amount) {
		super();
		this.transactionId = transactionId;
		this.tradeId = tradeId;
		this.customerId = customerId;
		this.amount = amount;
	}
	


}
