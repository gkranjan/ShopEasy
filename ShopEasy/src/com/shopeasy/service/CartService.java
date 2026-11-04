package com.shopeasy.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.shopeasy.model.CartItem;
import com.shopeasy.model.Product;

public class CartService {

	private List<CartItem> items = new ArrayList<CartItem>();

	public void addToCart(Product product, int quantity) {

		if (product == null) {
			System.out.println("Product not found.");
			return;
		}

		if (quantity <= 0) {
			System.out.println("Quantity must be greater than zero.");
			return;
		}

		for (CartItem item : items) {
			if (item.getProduct().getProductId() == product.getProductId()) {

				int newQuantity = item.getQuantity() + quantity;

				if (newQuantity > product.getStock()) {
					System.out.println("Not enough stock available.");
					return;
				}

				item.increaseQuantity(quantity);
				System.out.println("Cart quantity updated successfully.");
				return;
			}
		}

		if (quantity > product.getStock()) {
			System.out.println("Not enough stock available.");
			return;
		}

		items.add(new CartItem(product, quantity));

		System.out.println("Product added to cart successfully.");
	}

	public void displayCart() {

		if (items.isEmpty()) {
			System.out.println("Your cart is empty.");
			return;
		}

		System.out.println();
		System.out.println("============== SHOPPING CART ==============");

		System.out.printf("%-20s %-8s %-15s %s%n", "Product", "Qty", "Unit Price", "Subtotal");

		for (CartItem item : items) {
			item.displayItem();
		}

		System.out.printf("Cart Total: Rs. %.2f%n", getTotal());
	}

	public void removeFromCart(int productId) {

		Iterator<CartItem> iterator = items.iterator();

		while (iterator.hasNext()) {
			CartItem item = iterator.next();

			if (item.getProduct().getProductId() == productId) {

				iterator.remove();

				System.out.println("Product removed from cart.");
				return;
			}
		}

		System.out.println("Product not found in cart.");
	}

	public double getTotal() {
		double total = 0.0;

		for (CartItem item : items) {
			total += item.getSubtotal();
		}

		return total;
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void clearCart() {
		items.clear();
	}
}