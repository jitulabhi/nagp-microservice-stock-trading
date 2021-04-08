package com.labhi.bankaccount.controller;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labhi.bankaccount.model.BankDepositModel;
import com.labhi.bankaccount.model.BankWithdrawModel;
import com.labhi.bankaccount.service.BankAccountService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("bank")
public class BankAccountController {
	
	
	
	@Autowired
	 private BankAccountService service;
	
	

	
	@PostMapping("/withdraw")
	public Response addToTradingAccount(@RequestBody BankWithdrawModel request) {
		log.info("addToTradingAccount");
		service.withdraw(request);
		return Response.ok().build();
		
	}
	
	@PostMapping("/deposit")
	public Response removeFromTradingAccount(@RequestBody BankDepositModel request) {
		log.info("removeFromTradingAccount");
		service.deposit(request);
		return Response.ok().build();
		
	}

}
