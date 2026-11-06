package com.rental.main;

import java.io.IOException;

import com.rental.model.Car;
import com.rental.model.Customer;
import com.rental.model.RentalBooking;
import com.rental.model.Vehicle;
import com.rental.service.RentalService;
import com.rental.service.RentalServiceImpl;
import com.rental.utility.BookingBackup;

public class RentalApplication {

	public static void main(String[] args) throws CloneNotSupportedException {

		try {
			// step 1: Create customer
			Customer customer = new Customer(101, "Rahul Kumar", "7044565566");

			// step 2:Create vehicle using array
			Vehicle[] vehicles = new Vehicle[2];

			vehicles[0] = new Car("BR01AB1234", "Swift", 1500, "Petrol");

			vehicles[1] = new Car("JH01CD1234", "Bolero", 1800, "Diesel");

			// step 3: Display customer
			System.out.println("===== CUSTOMER DETAILS =====");
			customer.displayCustomer();

			// step 4: Display vehicles;
			System.out.println("\n===== VEHICLE DETAILS ======");

			for (Vehicle vehicle : vehicles) {
				vehicle.displayVechile();
				System.out.println("-------------------------");
			}

			// step 5: Interface and polymorphism
			RentalService service = new RentalServiceImpl();
			double totalRent = service.calculateRent(vehicles[0].getRentPerDay(), 3);

			service.confirmBooking();
			// step 6: Create booking
			
			RentalBooking booking = new RentalBooking("BOOK101", customer, vehicles[0], 3, totalRent);
			System.out.println("\n====== BOOKING DETAILS =======");
			booking.displayBooking();

			// step 7: Clone booking
			RentalBooking backup = (RentalBooking) booking.clone();

			System.out.println("\n======== CLONED BOOKING ========");
			backup.displayBooking();

			// step 8: serialization
			BookingBackup.saveBooking(booking);

			// step 9: DeSerialization

			RentalBooking restored = BookingBackup.restoreBooking();

			if (restored != null) {
				System.out.println("\n===== RESTORED BOOKING =======");
				restored.displayBooking();
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

}
