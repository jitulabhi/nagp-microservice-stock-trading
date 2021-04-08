package com.labhi.stockpricehistory.controller;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labhi.stockpricehistory.dao.StockPriceHistoryRepository;

@RestController
@RequestMapping("stock-price-history")
public class StockPriceHistoryController {
	
	@Autowired
	private StockPriceHistoryRepository repo;
	
	@GetMapping("/{stockId}")
	public Response fetchByStock(@PathVariable("stockId") String stockId) {
		return Response.ok(repo.findAllByStockId(stockId)).build();
	}

}
