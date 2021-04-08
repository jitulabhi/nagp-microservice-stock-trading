package com.labhi.stocktradingservice.service;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import com.labhi.cqrs.command.TradeWithdrawCommand;
import com.labhi.cqrs.event.StockBuyEvent;
import com.labhi.cqrs.event.TradeWithdrawSuccessEvent;

import lombok.extern.slf4j.Slf4j;

@Saga
@Slf4j
public class StockTradingSaga {

	@Autowired
	private CommandGateway commandGateway;

	@StartSaga
	@SagaEventHandler(associationProperty = "tradeId")
	public void handle(StockBuyEvent stockBuyEvent) {
		String transactionId = UUID.randomUUID().toString();
		SagaLifecycle.associateWith("transactionId", transactionId);
		log.info("saga - stock buy event with trade id and transaction id {}, {}", stockBuyEvent.tradeId, transactionId);
		commandGateway.send(new TradeWithdrawCommand(stockBuyEvent.getTradeId(), transactionId, stockBuyEvent.getCustomerId(),
				stockBuyEvent.getPrice() * stockBuyEvent.getQuantity()));

	}
	
	
	@SagaEventHandler(associationProperty = "transactionId")
	public void handle(TradeWithdrawSuccessEvent tradeWithdrawSuccessEvent) {
		log.info("tradeWithdrawSuccessEvent received {}", tradeWithdrawSuccessEvent);
		SagaLifecycle.end();

	}

}
