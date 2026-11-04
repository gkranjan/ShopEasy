package com.shopeasy.payment;

public class CashOnDelivery implements Payment {

	@Override
	public boolean pay(double amount) {
		System.out.printf("Cash on delivery selected: Rs. %.2f%n", amount);

		System.out.println("Order will be paid for on delivery.");

		return true;
	}
}