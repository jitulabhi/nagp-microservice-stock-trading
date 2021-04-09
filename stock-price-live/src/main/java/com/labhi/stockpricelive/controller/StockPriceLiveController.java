package com.labhi.stockpricelive.controller;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Produces;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labhi.stockprice.model.StockPrice;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("stock-price-live")
public class StockPriceLiveController {

	@GetMapping(path = "/{stockId}", produces = { org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE })
	public Flux<StockPrice> fetchLive(@PathVariable("stockId") String stockId) {

		List<StockPrice> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			StockPrice stockPrice = new StockPrice();
			stockPrice.setStockId(stockId);
			stockPrice.setStockName(stockId + " Company");
			stockPrice.setBuyPrice(RandomUtils.nextDouble());
			stockPrice.setSellPrice(RandomUtils.nextDouble());
			list.add(stockPrice);
		}
		StockPrice[] arr = new StockPrice[1000];
		arr = list.toArray(arr);
		return Flux.just(arr).delayElements(Duration.ofSeconds(10));
	}

}
