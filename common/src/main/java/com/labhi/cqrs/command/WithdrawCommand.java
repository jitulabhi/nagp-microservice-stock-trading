package com.labhi.cqrs.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class WithdrawCommand {

	@TargetAggregateIdentifier
	 public String customerId;
	
	public double amount;
	
	
	public WithdrawCommand(String customerId, double amount) {
		this.customerId = customerId;
		this.amount = amount;
	}

}
