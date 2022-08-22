package com.example.AmExAssessment.models;

import java.util.ArrayList;
import java.util.UUID;

public class OrderSummary {
	private ArrayList<Order> orders;
	private double grandTotal;
	private UUID id;
	
	public OrderSummary(ArrayList<Order> orders, double grandTotal) {
		super();
		this.orders = orders;
		this.grandTotal = grandTotal;
		this.id = UUID.randomUUID();
	}
	
	public UUID getId() {
		return id;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
	public double getGrandTotal() {
		return grandTotal;
	}
}
