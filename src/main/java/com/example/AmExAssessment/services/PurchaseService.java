package com.example.AmExAssessment.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.AmExAssessment.models.Order;
import com.example.AmExAssessment.models.OrderSummary;
import com.example.AmExAssessment.models.Product;
import com.example.AmExAssessment.repo.ProductRepo;

@Service
public class PurchaseService {
	@Autowired
	private ProductRepo productRepo;
	
	
	public PurchaseService() {
		this.productRepo = new ProductRepo();
	}
	

	public OrderSummary purchaseItems(List<Order> orders) {
		ArrayList<Order> listOfOrders = new ArrayList<Order>();
		Product prod;
		double grandTotal = 0;

		for(Order order: orders) {
			System.out.println(order.getProductID());
			prod = productRepo.getProductById((int) order.getProductID());
			double price = prod.getPrice();
			
			order.setTotal(price*order.getQuantityPurchased());
			grandTotal += order.getTotal();
			listOfOrders.add(order);
		}

		OrderSummary sum = new OrderSummary(listOfOrders, grandTotal);
		
		return sum;
	}
}
