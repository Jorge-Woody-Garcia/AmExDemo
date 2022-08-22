package com.example.AmExAssessment.controllers;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/orders")
	public Collection<OrderSummary> getAllOrders(){
		
		return this.purchaseService.getAllOrders();
	}
	
	@GetMapping("/orders/{id}")
	public OrderSummary getOrderById(@PathVariable UUID id){
		return this.purchaseService.getOrderById(id);
	}
}
