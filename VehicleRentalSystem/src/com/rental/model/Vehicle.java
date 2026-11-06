package com.rental.model;

import java.io.Serializable;

public abstract class Vehicle implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String vehicleNumber;
	protected String vehicleName;
	protected double rentPerDay;

	public Vehicle(String vehicleNumber, String vehicleName, double rentPerDay) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.vehicleName = vehicleName;
		this.rentPerDay = rentPerDay;
	}

	public abstract void displayVechile();

	public double getRentPerDay() {
		return rentPerDay;
	}

	public String getVehicleName() {
		return vehicleName;
	}

}
