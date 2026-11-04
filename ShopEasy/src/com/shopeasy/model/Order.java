package com.shopeasy.model;

public class Order {

	private int orderId;
	private Customer customer;
	private double totalAmount;
	private String paymentMethod;

	public Order(int orderId, Customer customer, double totalAmount, String paymentMethod) {
		this.orderId = orderId;
		this.customer = customer;
		this.totalAmount = totalAmount;
		this.paymentMethod = paymentMethod;
	}

	public void displayOrder() {
		System.out.println();
		System.out.println("============== ORDER CONFIRMATION ==============");

		System.out.println("Order ID      : " + orderId);
		System.out.println("Customer      : " + customer.getName());
		System.out.printf("Total Amount  : Rs. %.2f%n", totalAmount);
		System.out.println("Payment Method: " + paymentMethod);

		System.out.println("Order Status  : CONFIRMED");

		System.out.println("================================================");
	}
}