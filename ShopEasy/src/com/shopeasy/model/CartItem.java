package com.shopeasy.model;

public class CartItem {

	private Product product;
	private int quantity;

	public CartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void increaseQuantity(int quantity) {
		this.quantity += quantity;
	}

	public double getSubtotal() {
		return product.getPrice() * quantity;
	}

	public void displayItem() {
		System.out.printf("%-20s %-8d Rs. %-10.2f Rs. %.2f%n", product.getName(), quantity, product.getPrice(),
				getSubtotal());
	}
}