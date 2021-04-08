package com.labhi.cqrs.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DepositCommand {
	
	@TargetAggregateIdentifier
	 public String customerId;
	
	public double amount;
	
	
	public DepositCommand(String customerId, double amount) {
		this.customerId = customerId;
		this.amount = amount;
	}

}
