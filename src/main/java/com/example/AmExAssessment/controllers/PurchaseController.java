package com.example.AmExAssessment.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.AmExAssessment.models.Order;
import com.example.AmExAssessment.models.OrderSummary;
import com.example.AmExAssessment.services.PurchaseService;

@RestController
public class PurchaseController {
	private final PurchaseService purchaseService;
	
	public PurchaseController(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}
	
	@GetMapping("/purchase")
	@ResponseBody
	public OrderSummary purchaseItems(@RequestBody List<Order> orders) {
		return this.purchaseService.purchaseItems(orders);
	}
}
