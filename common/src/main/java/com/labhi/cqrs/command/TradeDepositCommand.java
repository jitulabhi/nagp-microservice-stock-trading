package com.labhi.cqrs.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class TradeDepositCommand {

	@TargetAggregateIdentifier
	 public String transactionId;
	
	public String tradeId;
	
	public String customerId;
	
	public double amount;

	public TradeDepositCommand(String transactionId, String tradeId, String customerId, double amount) {
		super();
		this.transactionId = transactionId;
		this.tradeId = tradeId;
		this.customerId = customerId;
		this.amount = amount;
	}
	


}
