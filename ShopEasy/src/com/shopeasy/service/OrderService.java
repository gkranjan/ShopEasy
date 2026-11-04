package com.shopeasy.service;

import java.util.List;

import com.shopeasy.model.CartItem;
import com.shopeasy.model.Customer;
import com.shopeasy.model.Order;
import com.shopeasy.model.Product;
import com.shopeasy.payment.Payment;

public class OrderService {

	private int nextOrderId = 1001;

	public void placeOrder(Customer customer, CartService cart, Payment payment, String paymentMethod) {

		if (cart.isEmpty()) {
			System.out.println("Cannot place order. Cart is empty.");
			return;
		}

		List<CartItem> items = cart.getItems();

		// Step 1: Validate all items before changing stock.
		for (CartItem item : items) {
			Product product = item.getProduct();

			if (item.getQuantity() <= 0 || item.getQuantity() > product.getStock()) {

				System.out.println("Order failed: insufficient stock for " + product.getName());
				return;
			}
		}

		// Step 2: Calculate total.
		double total = cart.getTotal();

		// Step 3: Process selected payment.
		boolean paymentSuccessful = payment.pay(total);

		if (!paymentSuccessful) {
			System.out.println("Payment failed. Order was not placed.");
			return;
		}

		// Step 4: Update inventory.
		for (CartItem item : items) {
			item.getProduct().reduceStock(item.getQuantity());
		}

		// Step 5: Create order.
		Order order = new Order(nextOrderId++, customer, total, paymentMethod);

		order.displayOrder();

		// Step 6: Empty the cart after successful checkout.
		cart.clearCart();
	}
}