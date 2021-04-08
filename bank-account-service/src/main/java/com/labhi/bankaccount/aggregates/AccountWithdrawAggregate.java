package com.labhi.bankaccount.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.labhi.cqrs.command.WithdrawCommand;
import com.labhi.cqrs.event.WithdrawEvent;

@Aggregate
public class AccountWithdrawAggregate {
	
	@AggregateIdentifier
	private String customerId;
	
	public double amount;
	
	 @CommandHandler
	    public AccountWithdrawAggregate(WithdrawCommand command){
	        AggregateLifecycle.apply(new WithdrawEvent(command.customerId, command.amount));
	    }

	    @EventSourcingHandler
	    protected void on(WithdrawEvent event){
	        this.customerId = event.customerId;
	        this.amount = event.amount;
	       
	    }

}
