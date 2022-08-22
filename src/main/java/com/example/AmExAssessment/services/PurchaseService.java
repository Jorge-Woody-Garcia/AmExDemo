package com.example.AmExAssessment.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.AmExAssessment.models.Order;
import com.example.AmExAssessment.models.OrderSummary;
import com.example.AmExAssessment.models.Product;
import com.example.AmExAssessment.repo.ProductRepo;

@Service
public class PurchaseService {
	
	Map<String, OrderSummary> appUserOrders = new ConcurrentHashMap<String, OrderSummary>();
	
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
			System.out.println(order.getQuantityPurchased());
			prod = productRepo.getProductById((int) order.getProductID());
			double price = prod.getPrice();
			
			if(prod.isDiscount() == true) {
				
				int remainder = order.getQuantityPurchased()%prod.getDiscountNumerator();
				double x = ((order.getQuantityPurchased()-remainder)/prod.getDiscountNumerator())*prod.getPrice()*prod.getDiscountDenominator();
				double orderTotal = x + (order.getQuantityPurchased()%prod.getDiscountNumerator())*prod.getPrice();
				order.setTotal(orderTotal);
			}
			else {
				order.setTotal(price*order.getQuantityPurchased());
			}
			grandTotal += order.getTotal();
			listOfOrders.add(order);
		}

		OrderSummary sum = new OrderSummary(listOfOrders, grandTotal);
		
		appUserOrders.put(sum.getId().toString(), sum);
		
		return sum;
	}
	
	public Collection<OrderSummary> getAllOrders(){

		Collection<OrderSummary> allSummaries = appUserOrders.values();
		
		return allSummaries;
	}
	
	public OrderSummary getOrderById(UUID id){
		OrderSummary sum = appUserOrders.get(id.toString());
		return sum;
	}
}
