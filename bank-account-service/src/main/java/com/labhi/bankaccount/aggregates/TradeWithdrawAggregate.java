package com.labhi.bankaccount.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.labhi.cqrs.command.TradeWithdrawCommand;
import com.labhi.cqrs.event.TradeWithdrawEvent;

@Aggregate
public class TradeWithdrawAggregate {


	@AggregateIdentifier
	public String transactionId;

	public String tradeId;
	public String customerId;

	public String stockId;

	public String stockName;

	public double quantity;

	public double price;

	public double amount;
	
	public String status;
	
	@CommandHandler
	public TradeWithdrawAggregate(TradeWithdrawCommand command) {
		AggregateLifecycle.apply(
				new TradeWithdrawEvent(command.transactionId, command.tradeId, command.customerId, command.amount));
	}

	@EventSourcingHandler
	protected void on(TradeWithdrawEvent event) {
		this.tradeId = event.tradeId;
		this.transactionId = event.transactionId;
		this.customerId = event.customerId;
		this.amount = event.amount;

	}
}
