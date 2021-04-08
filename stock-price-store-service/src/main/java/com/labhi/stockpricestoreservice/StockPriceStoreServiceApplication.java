package com.labhi.stockpricestoreservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class StockPriceStoreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockPriceStoreServiceApplication.class, args);
	}

}
