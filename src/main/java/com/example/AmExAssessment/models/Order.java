package com.example.AmExAssessment.models;

public class Order {

	private int productID;
	private int quantityPurchased;
	private double total;
	
	public Order(int productID, int quantityPurchased) {
		super();
		this.productID = productID;
		this.quantityPurchased = quantityPurchased;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public int getProductID() {
		return productID;
	}
	
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	public int getQuantityPurchased() {
		return quantityPurchased;
	}
	
	public void setQuantityPurchased(int quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
	}
}
