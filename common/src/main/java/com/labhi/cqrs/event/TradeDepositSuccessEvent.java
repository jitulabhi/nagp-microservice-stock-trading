package com.labhi.cqrs.event;

public class TradeDepositSuccessEvent {

	String tradeId;
	String transactionId;

	public TradeDepositSuccessEvent(String tradeId, String transactionId) {
		super();
		this.tradeId = tradeId;
		this.transactionId = transactionId;
	}

}
