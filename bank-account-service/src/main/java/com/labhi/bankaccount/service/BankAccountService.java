package com.labhi.bankaccount.service;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labhi.bankaccount.dao.BankAccountRepository;
import com.labhi.bankaccount.model.BankAccount;
import com.labhi.bankaccount.model.BankDepositModel;
import com.labhi.bankaccount.model.BankWithdrawModel;
import com.labhi.cqrs.command.DepositCommand;
import com.labhi.cqrs.command.TradeWithdrawSuccessCommand;
import com.labhi.cqrs.command.WithdrawCommand;
import com.labhi.cqrs.event.TradeWithdrawEvent;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BankAccountService {
	
	@Autowired
	private BankAccountRepository repo;
	
	@Autowired
	private CommandGateway gateway;
	
	public void withdraw(BankWithdrawModel request) {
		BankAccount acc = new BankAccount();
		acc.setCustomerId(request.getCustomerId());
		acc.setWithdrawAmount(request.getAmount());
		repo.save(acc);
		gateway.send(new WithdrawCommand(request.getCustomerId(), request.getAmount()));
	}

	public void deposit(BankDepositModel request) {
		BankAccount acc = new BankAccount();
		acc.setCustomerId(request.getCustomerId());
		acc.setDepositAmount(request.getAmount());
		repo.save(acc);
		gateway.send(new DepositCommand(request.getCustomerId(),request.getAmount()));
		
	}
	
	@EventHandler
	public void handle(TradeWithdrawEvent event) {
		log.info("TradeWithdrawEvent captured with tradeId {} and transaction Id {}", event.tradeId, event.transactionId);
		BankAccount acc = new BankAccount();
		acc.setCustomerId(event.customerId);
		acc.setWithdrawAmount(event.amount);
		acc.setTradeId(event.tradeId);
		acc.setTransactionId(event.transactionId);
		repo.save(acc);
		gateway.send(new WithdrawCommand(event.customerId, event.amount));
		gateway.send(new TradeWithdrawSuccessCommand(event.tradeId, event.transactionId));
	}

}
