package com.rental.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.rental.model.RentalBooking;

public class BookingBackup {
	
	
	public static void saveBooking(RentalBooking booking) throws FileNotFoundException, IOException {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("booking.dat")))
		{
			out.writeObject(booking);
			System.out.println("Booking saved successfully!");
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public static RentalBooking restoreBooking() throws FileNotFoundException, IOException
	{
		
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("booking.dat")))
		{
			
		
		return (RentalBooking) in.readObject();
	}
	catch(IOException | ClassNotFoundException e)
	{
		e.printStackTrace();
		return null;
	}
	}
}
