package com.labhi.stockholdingsnapshot.controller;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labhi.stockholdingsnapshot.dao.StockHoldingSnapshotRepository;

@RestController
@RequestMapping("stock-holding-snapshot")
public class StockHoldingSnapshotController {

	@Autowired
	StockHoldingSnapshotRepository repo;

	@GetMapping("/{customerId}")
	public Response getSnapshot(@PathVariable("customerId") String customerId) {
		return Response.ok(repo.findAllByCustomerId(customerId)).build();
	}

}
