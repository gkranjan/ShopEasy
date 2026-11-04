package com.shopeasy.model;

public class Product {

	private int productId;
	private String name;
	private double price;
	private int stock;

	public Product(int productId, String name, double price, int stock) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public void reduceStock(int quantity) {
		if (quantity <= 0 || quantity > stock) {
			throw new IllegalArgumentException("Invalid stock quantity.");
		}

		stock -= quantity;
	}

	public void displayProduct() {
		System.out.printf("%-5d %-20s Rs. %-10.2f %d%n", productId, name, price, stock);
	}
}