package com.labhi.accountbalance.service;

import java.util.List;
import java.util.Optional;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.labhi.accountbalance.dao.BankAccountRepository;
import com.labhi.accountbalance.dao.AccountBalanceRepository;
import com.labhi.accountbalance.model.AccountBalance;
import com.labhi.bankaccount.model.BankAccount;
import com.labhi.cqrs.event.DepositEvent;
import com.labhi.cqrs.event.WithdrawEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AccountBalanceService {
	
	@Autowired
	private AccountBalanceRepository repo;
	
	@Autowired
	private BankAccountRepository allRepo;
	

	@EventHandler
	public void handle(DepositEvent event) {
		log.info("Deposit event {}", event);
		recalculateBalance(event.customerId);
	}
	
	

	@EventHandler
	public void handle(WithdrawEvent event) {
		log.info("Withdraw event {}", event);
		recalculateBalance(event.customerId);
	}
	
	private void recalculateBalance(String customerId) {
		List<BankAccount> list = allRepo.findAllByCustomerId(customerId);
		
		if(!CollectionUtils.isEmpty(list)) {
			double balance = list.stream().filter(rec -> rec.getDepositAmount() != null).mapToDouble(BankAccount::getDepositAmount).sum() - list.stream().filter(rec -> rec.getWithdrawAmount() != null).mapToDouble(BankAccount::getWithdrawAmount).sum();
			Optional<AccountBalance> existing = repo.findByCustomerId(customerId);
			if(existing.isPresent()) {
				AccountBalance exist = existing.get();
				exist.balance = balance;
				repo.save(exist);
			}else {
				AccountBalance newRecord = new AccountBalance();
				newRecord.customerId = customerId;
				newRecord.balance = balance;
				repo.save(newRecord);
			}
		}
	}
	

}
