package com.labhi.stockpricepullservice.config;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.labhi.stockprice.model.StockCompany;
import com.labhi.stockprice.model.StockPrice;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class StockCompanyToPriceProcessor implements ItemProcessor<StockCompany, StockPrice> {

	@Override
	public StockPrice process(StockCompany item) throws Exception {
		log.info("pull price for {}", item);
		StockPrice price = new StockPrice();
		price.setStockId(item.getStockId());
		price.setStockName(item.getName());
		price.setBuyPrice(Math.random());
		price.setSellPrice(Math.random());		
		return price;
	}

}
