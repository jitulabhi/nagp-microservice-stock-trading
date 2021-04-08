package com.labhi.stocktrading.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stock-trading")
public class StockTrading {
	@Id
	private ObjectId id;
	
	private String tradeId;
	private String customerId;
	private String stockId;
	private String stockName;
	private long buyQuantity;
	private double buyPrice;
	private long sellQuantity;
	private double sellPrice;
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
	public long getBuyQuantity() {
		return buyQuantity;
	}
	public void setBuyQuantity(long buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public long getSellQuantity() {
		return sellQuantity;
	}
	public void setSellQuantity(long sellQuantity) {
		this.sellQuantity = sellQuantity;
	}
	public double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	
	
}
