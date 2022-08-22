package com.example.AmExAssessment.repo;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.AmExAssessment.models.Product;

@Component
public class ProductRepo {
	ArrayList<Product> products;


	public ProductRepo() {

		this.products = new ArrayList<Product>();

		Product apple = new Product(1, "apple", 0.60);
		Product orange = new Product(2, "orange", 0.25);
		
		products.add(apple);
		products.add(orange);
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public Product getProductById(int id) {
		Product product;
		for(Product p: products) {
			if(p.getId() == id) {
				return product = p;
			}
		}
		return null;
	}
}
