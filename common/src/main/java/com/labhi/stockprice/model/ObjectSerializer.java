package com.labhi.stockprice.model;

import org.apache.commons.lang.SerializationUtils;
import org.apache.kafka.common.serialization.Serializer;

public class ObjectSerializer<T extends StockPriceEvent> implements Serializer<T> {

	//@Override
	public byte[] serialize(String topic, T object) {
		return SerializationUtils.serialize(object);
	}
	
	
	
}
