package com.labhi.stockpricestoreservice.route;

import org.apache.camel.Converter;
import org.apache.camel.TypeConverters;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import com.labhi.stockprice.model.StockPrice;

@Component
public class MyPackageTypeConverter implements TypeConverters {

	

	  @Converter
	  public byte[] myPackageToByteArray(StockPrice source) {
	    return SerializationUtils.serialize(source);
	  }

	  @Converter
	  public StockPrice byteArrayToMyPackage(byte[] source) {
	    	return (StockPrice)SerializationUtils.deserialize(source);
	   
	  }

	}
