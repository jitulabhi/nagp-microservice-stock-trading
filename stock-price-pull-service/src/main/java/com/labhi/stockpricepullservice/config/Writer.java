package com.labhi.stockpricepullservice.config;

import org.springframework.batch.item.kafka.KafkaItemWriter;
import org.springframework.batch.item.kafka.builder.KafkaItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.labhi.stockprice.model.StockPrice;

@Component
public class Writer {
	
	@Autowired
	KafkaTemplate<String, StockPrice> template;
	
	

	@Bean
	public KafkaItemWriter<String, StockPrice> write() {
		return new KafkaItemWriterBuilder<String, StockPrice>().kafkaTemplate(template).itemKeyMapper(StockPrice::getStockId)
        .build();
		
	}

}
