package com.labhi.accountbalance.controller;

import java.util.Optional;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labhi.accountbalance.dao.AccountBalanceRepository;
import com.labhi.accountbalance.model.AccountBalance;
import com.labhi.accountbalance.model.CheckFundRequest;
import com.labhi.accountbalance.model.CheckFundResponse;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("account-balance")
@Slf4j
public class AccountBalanceController {

	@Autowired
	private AccountBalanceRepository repo;
	
	@PostMapping("/check-fund")
	public Response checkFund(@RequestBody CheckFundRequest request) {
		log.info("check fund request {}", request);
		CheckFundResponse response = new CheckFundResponse();
		Optional<AccountBalance> obj = repo.findByCustomerId(request.getCustomerId());
		if(obj.isPresent()) {
			response.setEnough(obj.get().balance >= request.getFund());
		}
		log.info("check fund response {}", response);
				
		return Response.ok(response).build();
	}
}
