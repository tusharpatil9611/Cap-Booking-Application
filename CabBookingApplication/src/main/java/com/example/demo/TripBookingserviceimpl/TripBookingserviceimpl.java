package com.example.demo.TripBookingserviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.TripBookingEntity.Tripbooking;
import com.example.demo.TripBookingRepository.Tripbookingrepo;
import com.example.demo.TripBookingservice.tripbookservice;
@Service
public class TripBookingserviceimpl implements tripbookservice {
   
	@Autowired
	Tripbookingrepo repo;
	
	@Override
	public void insertTripBooking(Tripbooking tripbooking) {
		// TODO Auto-generated method stub
		repo.save(tripbooking);
	}

	@Override
	public void updateTripBooking(Tripbooking tripbooking) {
		// TODO Auto-generated method stub
		repo.save(tripbooking);
	}

	@Override
	public void deleteTripBooking(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public List<Tripbooking> viewAllTripCustomer() {
		// TODO Auto-generated method stub
		List<Tripbooking> lst=repo.findAll();
		System.out.println(lst.size());
		return lst;
	}

	@Override
	public float calculatrBill(int cutomerid) {
		// TODO Auto-generated method stub
		
		float totalbill=repo.getById(cutomerid).getDistanceinkm()*25;
		return totalbill;
		

	}

}
