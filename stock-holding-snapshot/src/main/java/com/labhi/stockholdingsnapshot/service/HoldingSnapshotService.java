package com.labhi.stockholdingsnapshot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.labhi.cqrs.event.StockBuyEvent;
import com.labhi.cqrs.event.StockSellEvent;
import com.labhi.stockholdingsnapshot.dao.StockHoldingSnapshotRepository;
import com.labhi.stockholdingsnapshot.dao.StockTradingHistoryRepository;
import com.labhi.stocktrading.model.StockHolding;
import com.labhi.stocktrading.model.StockTrading;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class HoldingSnapshotService {

	@Autowired
	StockTradingHistoryRepository historyRepo;

	@Autowired
	StockHoldingSnapshotRepository snapshotRepo;

	@EventHandler
	public void handle(StockBuyEvent event) {
		log.info("update the holding for buy event");
		recalculateHolding(event.getCustomerId(), event.getStockId(), event.getStockName());
	}

	@EventHandler
	public void handle(StockSellEvent event) {
		log.info("update the holding for sell event");
		recalculateHolding(event.getCustomerId(), event.getStockId(), event.getStockName());
	}

	private void recalculateHolding(String customerId, String stockId, String stockName) {

		List<StockTrading> list = historyRepo.findAllByCustomerId(customerId).stream()
				.filter(stock -> stock.getStockId().equalsIgnoreCase(stockId)).collect(Collectors.toList());
		long holdingQuantity = list.stream().collect(Collectors.summingLong(StockTrading::getBuyQuantity))
				- list.stream().collect(Collectors.summingLong(StockTrading::getSellQuantity));
		double holdingAmount = list.stream()
				.collect(Collectors.summingDouble(stock -> stock.getBuyPrice() * stock.getBuyQuantity()))
				- list.stream()
						.collect(Collectors.summingDouble(stock -> stock.getSellPrice() * stock.getSellQuantity()));

		List<StockHolding> snapshotList = snapshotRepo.findAllByCustomerId(customerId);
		if (CollectionUtils.isEmpty(snapshotList)) {
			createRecord(customerId, stockId, holdingQuantity, holdingAmount);
		} else {
			List<StockHolding> exist = snapshotList.stream().filter(hold -> hold.getStockId().equalsIgnoreCase(stockId))
					.collect(Collectors.toList());
			if (!CollectionUtils.isEmpty(exist)) {
				updateRecord(holdingQuantity, holdingAmount, exist);
			}else {
				createRecord(customerId, stockId, holdingQuantity, holdingAmount);
			}
		}

	}

	private void updateRecord(long holdingQuantity, double holdingAmount, List<StockHolding> exist) {
		StockHolding hold = exist.get(0);
		hold.setHoldingAmount(holdingAmount);
		hold.setHoldingQuantity(holdingQuantity);
		snapshotRepo.save(hold);
	}

	private void createRecord(String customerId, String stockId, long holdingQuantity, double holdingAmount) {
		StockHolding hold = new StockHolding();
		hold.setHoldingAmount(holdingAmount);
		hold.setHoldingQuantity(holdingQuantity);
		hold.setCustomerId(customerId);
		hold.setStockId(stockId);
		snapshotRepo.save(hold);
	}

}
