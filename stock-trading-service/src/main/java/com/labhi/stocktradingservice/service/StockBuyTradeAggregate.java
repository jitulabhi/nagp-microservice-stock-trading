package com.labhi.stocktradingservice.service;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.labhi.cqrs.command.StockBuyCommand;
import com.labhi.cqrs.event.StockBuyEvent;

@Aggregate
public class StockBuyTradeAggregate {

	@AggregateIdentifier
	public String tradeId;

	public String transactionId;

	public String customerId;

	public String stockId;

	public String stockName;

	public double quantity;

	public double price;

	public double amount;

	@CommandHandler
	public StockBuyTradeAggregate(StockBuyCommand command) {
		AggregateLifecycle.apply(new StockBuyEvent(command.tradeId, command.customerId, command.stockId,
				command.stockName, command.quantity, command.price));
	}

	@EventSourcingHandler
	protected void on(StockBuyEvent event) {
		this.tradeId = event.tradeId;
		this.customerId = event.getCustomerId();
		this.stockId = event.getStockId();
		this.stockName = event.getStockName();
		this.quantity = event.getQuantity();
		this.price = event.getPrice();

	}

	

}
