package com.labhi.stockpricestoreservice.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.labhi.stockprice.model.StockPrice;

@Component
public class KafkaMongoRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("kafka:{{camel.component.kafka.configuration.topic}}").convertBodyTo(StockPrice.class)
				.to("mongodb:mongoClient?database={{camel.component.mongodb3.database}}"
						+ "&collection={{camel.component.mongodb3.collection}}&operation={{camel.component.mongodb3.operation}}");

	}

}
