package com.rental.model;

import java.io.Serializable;

public class RentalBooking  implements Serializable,Cloneable{

	
	private static final long serialVersionUID = 1L;
	
	private String bookingId;
	private Customer customer;
	private Vehicle vehicle;
	private int rentalDays;
	private double totalAmount;
	
	public RentalBooking(String bookingId, Customer customer, Vehicle vehicle, int rentalDays, double totalAmount) {
		super();
		this.bookingId = bookingId;
		this.customer = customer;
		this.vehicle = vehicle;
		this.rentalDays = rentalDays;
		this.totalAmount = totalAmount;
	}
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
	
	public void displayBooking()
	{
		System.out.println("Booking ID: "+bookingId);
		System.out.println("Customer: "+customer.getCustomerName());
		System.out.println("Vehicle: " +vehicle.vehicleName);
		System.out.println("Rental Days: "+rentalDays);
		System.out.println("Total Amount: "+totalAmount);
	}

}
