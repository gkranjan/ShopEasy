package com.rental.service;

public class RentalServiceImpl implements RentalService{

	@Override
	public double calculateRent(double rentPerDay, int days) {

		if(days <=0)
		{
			throw new IllegalArgumentException("Rental days must be freater then Zero");
		}
		
		return rentPerDay * days;
	}

	@Override
	public void confirmBooking() {

		System.out.println("Booking confirmed successfully!");
	}
	
	

}
