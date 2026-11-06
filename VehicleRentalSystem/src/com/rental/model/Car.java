package com.rental.model;

public class Car extends Vehicle{
	
	private String fuelType;
	public Car(String number,String name,double rent,String fuelType)
	{
		super(number ,name,rent);
		
		this.fuelType=fuelType;
	}
	@Override
	public void displayVechile() {
		
		System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Name: " + vehicleName);
        System.out.println("Rent Per Day: " + rentPerDay);
        System.out.println("Fuel Type: " + fuelType);
	}

}
