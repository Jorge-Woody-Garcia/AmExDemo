package com.example.AmExAssessment.models;


public class Product {
	
	private int id;
	private String name;
	private double price;
	private boolean isDiscount;
	private int discountNumerator;
	private int discountDenominator;

	public Product() {
		super();
	}

	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public Product(int id, String name, double price, boolean isDiscount, int discountNumerator,
			int discountDenominator) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.isDiscount = isDiscount;
		this.discountNumerator = discountNumerator;
		this.discountDenominator = discountDenominator;
	}

	public boolean isDiscount() {
		return isDiscount;
	}

	public void setDiscount(boolean isDiscount) {
		this.isDiscount = isDiscount;
	}

	public int getDiscountNumerator() {
		return discountNumerator;
	}

	public void setDiscountNumerator(int discountNumerator) {
		this.discountNumerator = discountNumerator;
	}

	public int getDiscountDenominator() {
		return discountDenominator;
	}

	public void setDiscountDenominator(int discountDenominator) {
		if(discountDenominator <= 0)
			throw new IllegalArgumentException("Cannot divide by 0 or have negative Products");
		this.discountDenominator = discountDenominator;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
