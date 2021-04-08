package com.labhi.stocktrading.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stock-holding")
public class StockHolding {

	@Id
	private ObjectId id;
	
	private String customerId;
	private String stockId;
	private String stockName;
	private long holdingQuantity;
	private double holdingAmount;
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public long getHoldingQuantity() {
		return holdingQuantity;
	}
	public void setHoldingQuantity(long holdingQuantity) {
		this.holdingQuantity = holdingQuantity;
	}
	public double getHoldingAmount() {
		return holdingAmount;
	}
	public void setHoldingAmount(double holdingAmount) {
		this.holdingAmount = holdingAmount;
	}
	
	
}
