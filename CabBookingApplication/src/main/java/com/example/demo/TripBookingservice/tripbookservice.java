package com.example.demo.TripBookingservice;

import java.util.List;

import com.example.demo.TripBookingEntity.Tripbooking;

public interface tripbookservice {

	public void insertTripBooking(Tripbooking tripbooking);
	public void updateTripBooking(Tripbooking tripbooking);
	public void deleteTripBooking(int id);
	public List<Tripbooking> viewAllTripCustomer();
	public float calculatrBill(int cutomerid);
	
	
	
}
