package com.labhi.stockprice.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stock-price-history")
public class StockPriceHistory {
	
	@Id
	private ObjectId id;

	private String stockId;
	private String stockName;
	private double buyPrice;
	private double sellPrice;
	
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
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
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "StockPriceHistory [id=" + id + ", stockId=" + stockId + ", stockName=" + stockName + ", buyPrice="
				+ buyPrice + ", sellPrice=" + sellPrice + "]";
	}
	
	
}
