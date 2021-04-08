package com.labhi.stocktradingservice.service;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.labhi.cqrs.command.StockSellCommand;
import com.labhi.cqrs.event.StockSellEvent;

@Aggregate
public class StockSellTradeAggregate {

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
	public StockSellTradeAggregate(StockSellCommand command) {
		AggregateLifecycle.apply(new StockSellEvent(command.tradeId, command.customerId, command.stockId,
				command.stockName, command.quantity, command.price));
	}

	@EventSourcingHandler
	protected void on(StockSellEvent event) {
		this.tradeId = event.tradeId;
		this.customerId = event.getCustomerId();
		this.stockId = event.getStockId();
		this.stockName = event.getStockName();
		this.quantity = event.getQuantity();
		this.price = event.getPrice();

	}

	

}
