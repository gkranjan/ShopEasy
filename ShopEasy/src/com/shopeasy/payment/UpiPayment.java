package com.shopeasy.payment;

public class UpiPayment implements Payment {

	@Override
	public boolean pay(double amount) {
		System.out.printf("Processing simulated UPI payment: Rs. %.2f%n", amount);

		System.out.println("UPI payment simulation successful.");

		return true;
	}
}