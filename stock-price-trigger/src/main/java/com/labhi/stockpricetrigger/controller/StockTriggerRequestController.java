package com.labhi.stockpricetrigger.controller;

import java.util.UUID;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labhi.stockpricetrigger.dao.StockTriggerRequestRepository;
import com.labhi.stockpricetrigger.model.StockTriggerRequest;

@RestController
@RequestMapping("stock-trigger-request")
public class StockTriggerRequestController {
	
	@Autowired
	StockTriggerRequestRepository repo;
	
	@PostMapping
	public Response StockTriggerRequest(@RequestBody StockTriggerRequest request) {
		request.setTriggerId(UUID.randomUUID().toString());
		repo.save(request);
		return Response.ok().build();
	}

}
