package com.labhi.stockpricepullservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class StockPricePullServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockPricePullServiceApplication.class, args);
	}

}
