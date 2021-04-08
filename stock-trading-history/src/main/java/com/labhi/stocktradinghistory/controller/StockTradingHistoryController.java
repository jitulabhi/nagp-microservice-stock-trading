package com.labhi.stocktradinghistory.controller;

import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labhi.stocktrading.model.StockTrading;
import com.labhi.stocktradinghistory.dao.StockTradingHistoryRepository;

@RestController
@RequestMapping("stock-trading-history")
public class StockTradingHistoryController {
	
	@Autowired
	private StockTradingHistoryRepository repo;
	
	@GetMapping("/{customerId}")
	public Response fetchHistory(@PathVariable("customerId") String customerId) {
		List<StockTrading> result = repo.findAllByCustomerId(customerId);
		return Response.ok(result).build();
	}

}
