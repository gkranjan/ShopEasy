package com.shopeasy.service;

import java.util.ArrayList;
import java.util.List;

import com.shopeasy.model.Product;

public class ProductService {

	private List<Product> products = new ArrayList<Product>();

	public  ProductService() {
		products.add(new Product(101, "Laptop", 55000.00, 5));

		products.add(new Product(102, "Keyboard", 800.00, 20));

		products.add(new Product(103, "Mouse", 500.00, 30));

		products.add(new Product(104, "Headphones", 1500.00, 10));

		products.add(new Product(105, "Monitor", 12000.00, 7));
	}

	public void displayProducts() {
		System.out.println();
		System.out.println("-------------------------------------------------------");
		System.out.printf("%-5s %-20s %-15s %s%n", "ID", "Product", "Price", "Stock");
		System.out.println("-------------------------------------------------------");

		for (Product product : products) {
			product.displayProduct();
		}

		System.out.println("-------------------------------------------------------");
	}

	public Product findProductById(int productId) {
		for (Product product : products) {
			if (product.getProductId() == productId) {
				return product;
			}
		}

		return null;
	}
}