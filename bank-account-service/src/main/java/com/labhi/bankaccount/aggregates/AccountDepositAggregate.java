package com.labhi.bankaccount.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.labhi.cqrs.command.DepositCommand;
import com.labhi.cqrs.event.DepositEvent;

@Aggregate
public class AccountDepositAggregate {
	
	@AggregateIdentifier
	public String customerId;
	
	public double amount;
	
	 @CommandHandler
	    public AccountDepositAggregate(DepositCommand command){
	        AggregateLifecycle.apply(new DepositEvent(command.customerId, command.amount));
	    }

	    @EventSourcingHandler
	    protected void on(DepositEvent event){
	        this.customerId = event.customerId;
	        this.amount = event.amount;
	       
	    }
	

}
