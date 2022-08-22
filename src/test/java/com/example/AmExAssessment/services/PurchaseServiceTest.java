package com.example.AmExAssessment.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.AmExAssessment.models.Order;
import com.example.AmExAssessment.models.OrderSummary;
import com.example.AmExAssessment.models.Product;



class PurchaseServiceTest {

	
	private List<Order> orders;
	private Order order;
	private Product prod;
	private OrderSummary orderSummary;
		
		
	@BeforeEach
	void setup() {
		orders = new ArrayList<>();
		
	}
	
	@Test
	public void itShouldBeAbleToCreateAProduct() {
		Product product = new Product(1, "apple", 1.00);
		assertEquals(1, product.getId());
		assertEquals("apple", product.getName());
		assertEquals(1.00, product.getPrice());
	}
	
	@Test
	public void itShouldNotAllowProductToHaveADenominatorOf0() {
		Product product = new Product();
		assertThrows(IllegalArgumentException.class, () -> { product.setDiscountDenominator(0); });
	}
	
	@Test
	public void itShouldBeAbleToCreateAnOrder() {
		Product product = new Product(1, "apple", 1.00);
		Order order = new Order(1, 100);
		order.setTotal(1000.00);
		assertEquals(1, order.getProductID());
		assertEquals(100, order.getQuantityPurchased());
		assertEquals(1000.00, order.getTotal());
	}
	
	@Test
	public void itShouldBeAbleToCreateAnOrderSummary() {
		Product product = new Product(1, "apple", 1.00);
		Order order = new Order(1, 100);
		order.setTotal(1000.00);
		ArrayList<Order> orders = new ArrayList<Order>();
		orders.add(order);
		OrderSummary orderSummary = new OrderSummary(orders, 1000.00);
		assertEquals(1000.00, orderSummary.getGrandTotal());
		assertEquals(orders, orderSummary.getOrders());
	}
	
	@Test
	void itShouldReturnASingleOrderInTheOrderSummary() {
		//given
		PurchaseService testService = new PurchaseService();
		order = new Order(1, 2);
		orders.add(order);
		
		//when
		orderSummary = testService.purchaseItems(orders);
		
		//then
		assertEquals(1, orderSummary.getOrders().size());
	}
	
	@Test
	void itShouldReturnMultipleOrdersInTheOrderSummary() {
		//given
		PurchaseService testService = new PurchaseService();
		order = new Order(1, 2);
		Order order2 = new Order(1, 2);
		orders.add(order);
		orders.add(order2);
		
		
		//when
		orderSummary = testService.purchaseItems(orders);
		
		//then
		assertEquals(2, orderSummary.getOrders().size());
	}
	
	@Test
	void itShouldAddAllOrdersCorrectlyIntoGrandTotal() {
		//given
		PurchaseService testService = new PurchaseService();
		order = new Order(2, 4);
		Order order2 = new Order(1, 5);
		orders.add(order);
		orders.add(order2);
		
		
		//when
		orderSummary = testService.purchaseItems(orders);
		
		//then
		assertEquals(4.00, orderSummary.getGrandTotal());
	}
	
	@Test
	void itShouldAddAllOrdersCorrectlyIntoGrandTotalAfterApplyingDiscount() {
		PurchaseService testService = new PurchaseService();
		
		order = new Order(3, 4);
		Order order2 = new Order(4, 6);
		Order order3 = new Order(2, 6);
		Order order4 = new Order(1, 6);
		orders.add(order);
		orders.add(order2);
		orders.add(order3);
		orders.add(order4);
		
		//when
		orderSummary = testService.purchaseItems(orders);
		
		//then
		assertEquals(6.10, orderSummary.getGrandTotal());
	}
	
	
	
	
}