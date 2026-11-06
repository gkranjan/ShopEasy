package com.rental.model;

import java.io.Serializable;

public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	private int customerId;
	private String customerName;
	private String mobileNumber;

	public Customer(int customerId, String customerName, String mobileNumber) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void displayCustomer() {

		String maskedMobile = mobileNumber.replaceAll("\\d(?=\\d{4})", "X");

		System.out.println("Customer ID: " + customerId);
		System.out.println("Customer Name: " + customerName);
		System.out.println("Mobile: " + maskedMobile);
	}

}
