package com.labhi.stocktradingservice.service;

import java.util.List;
import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.labhi.accountbalance.model.CheckFundRequest;
import com.labhi.accountbalance.model.CheckFundResponse;
import com.labhi.cqrs.command.StockBuyCommand;
import com.labhi.cqrs.command.StockSellCommand;
import com.labhi.cqrs.event.StockPriceTriggerEvent;
import com.labhi.stocktrading.model.StockTrading;
import com.labhi.stocktrading.model.StockTradingRequest;
import com.labhi.stocktradingservice.dao.StockTradingRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StockTradingService {

	@Autowired
	private StockTradingRepository repo;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private CommandGateway gateway;

	public void buy(StockTradingRequest request) {
		if (checkFund(request)) {
			log.info("check fund - true");
			String tradeId = UUID.randomUUID().toString(); 
			StockTrading obj = new StockTrading();
			obj.setBuyPrice(request.getPrice());
			obj.setBuyQuantity(request.getQuantity());
			obj.setCustomerId(request.getCustomerId());
			obj.setStockId(request.getStockId());
			obj.setStockName(request.getStockName());
			obj.setTradeId(tradeId);
			repo.save(obj);
			gateway.send(new StockBuyCommand(tradeId, request.getCustomerId(),
					request.getStockId(), request.getStockName(), request.getQuantity(), request.getPrice()));
		}else {
			log.info("check fund - false");
		}

		

	}

	@HystrixCommand(fallbackMethod = "checkFundFallback")
	public boolean checkFund(StockTradingRequest request) {
		log.info("calling check fund service");
		List<ServiceInstance> balanceServices = discoveryClient.getInstances("ACCOUNT-BALANCE");
		CheckFundRequest req = new CheckFundRequest();
		req.setCustomerId(request.getCustomerId());
		req.setFund(request.getPrice() * request.getQuantity());
		ResponseEntity<CheckFundResponse> rpc = new RestTemplate().postForEntity(balanceServices.get(0).getUri() + "/account-balance/check-fund", req,
				CheckFundResponse.class);
		return true;

	}

	public boolean checkFundFallback(StockTradingRequest request) {
		return true;
	}

	public void sell(StockTradingRequest request) {
		String tradeId = UUID.randomUUID().toString(); 
		
		StockTrading obj = new StockTrading();
		obj.setSellPrice(request.getPrice());
		obj.setSellQuantity(request.getQuantity());
		obj.setCustomerId(request.getCustomerId());
		obj.setStockId(request.getStockId());
		obj.setStockName(request.getStockName());
		repo.save(obj);
		gateway.send(new StockSellCommand(tradeId, request.getCustomerId(),
				request.getStockId(), request.getStockName(), request.getQuantity(), request.getPrice()));

	}
	
	@EventHandler
	public void handle(StockPriceTriggerEvent event) {
		log.info("stock price trigger event received");
		String tradeId = UUID.randomUUID().toString(); 
		StockTrading obj = new StockTrading();
		obj.setSellPrice(event.threshold);
		obj.setSellQuantity(event.quantity);
		obj.setCustomerId(event.customerId);
		obj.setStockId(event.stockId);
		obj.setStockName(event.stockName);
		obj.setTradeId(tradeId);
		repo.save(obj);
		gateway.send(new StockSellCommand(tradeId, obj.getCustomerId(),
				obj.getStockId(), obj.getStockName(), obj.getSellQuantity(), obj.getSellPrice()));
	}

}
