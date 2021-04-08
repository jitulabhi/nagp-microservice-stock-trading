package com.labhi.stocktradingservice.controller;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labhi.stocktrading.model.StockTrading;
import com.labhi.stocktrading.model.StockTradingRequest;
import com.labhi.stocktradingservice.service.StockTradingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("stocktrading")
public class StockTradingController {
	
	
	@Autowired
	private StockTradingService service;
	
	@PostMapping("/buy")
	public Response buy(@RequestBody StockTradingRequest request) {
		log.info("Stock buy request {}", request);
		service.buy(request);
		
		return Response.ok().build();
	}
	
	@PostMapping("/sell")
	public Response sell(@RequestBody StockTradingRequest request) {
		log.info("Stock sell request {}", request);
		service.sell(request);
		return Response.ok().build();
	}

}
