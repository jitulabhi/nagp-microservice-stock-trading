package com.labhi.cqrs.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class StockSellCommand {

	@TargetAggregateIdentifier
	public String tradeId;
	public String customerId;
	public String stockId;
	public String stockName;
	public long quantity;
	public double price;
	
	
	
	
	public StockSellCommand(String tradeId, String customerId, String stockId, String stockName, long quantity, double price) {
		this.tradeId = tradeId;
		this.customerId = customerId;
		this.stockId = stockId;
		this.stockName = stockName;
		this.quantity = quantity;
		this.price = price;
	}
}
