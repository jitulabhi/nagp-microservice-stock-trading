package com.labhi.cqrs.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class StockPriceTriggerCommand {

	@TargetAggregateIdentifier
	public String triggerId;
	public String stockId;
	public String stockName;
	public String customerId;
	public double threshold;
	public long quantity;
	public StockPriceTriggerCommand(String triggerId, String stockId, String stockName, String customerId,
			double threshold, long quantity) {
		super();
		this.triggerId = triggerId;
		this.stockId = stockId;
		this.stockName = stockName;
		this.customerId = customerId;
		this.threshold = threshold;
		this.quantity = quantity;
	}
	
	
}

