package com.labhi.stockpricetriggerjob.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.labhi.cqrs.command.StockPriceTriggerCommand;
import com.labhi.cqrs.event.StockPriceTriggerEvent;

@Aggregate
public class StockPriceTriggerAggregate {

	@AggregateIdentifier
	public String triggerId;
	public String stockId;
	public String stockName;
	public String customerId;
	public double threshold;
	public double quantity;

	@CommandHandler
	public StockPriceTriggerAggregate(StockPriceTriggerCommand command) {
		AggregateLifecycle.apply(new StockPriceTriggerEvent(command.triggerId, command.stockId, command.stockName,
				command.customerId, command.threshold, command.quantity));
	}

	@EventSourcingHandler
	protected void on(StockPriceTriggerEvent event) {
		this.triggerId = event.triggerId;
		this.stockId = event.stockId;
		this.stockName = event.stockName;
		this.customerId = event.customerId;
		this.threshold = event.threshold;
		this.quantity = event.quantity;

	}

}