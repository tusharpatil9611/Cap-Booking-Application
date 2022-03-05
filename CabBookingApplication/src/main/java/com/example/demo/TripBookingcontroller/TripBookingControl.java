package com.example.demo.TripBookingcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.TripBookingEntity.Tripbooking;
import com.example.demo.TripBookingserviceimpl.TripBookingserviceimpl;

@RestController
public class TripBookingControl {

	@Autowired
	private TripBookingserviceimpl tripBookingserviceimpl;

	@PostMapping("/savetrip")
	public void savetridata(@RequestBody Tripbooking tripbooking) {
		tripBookingserviceimpl.insertTripBooking(tripbooking);

	}

	@GetMapping("/gettrip")
	public List<Tripbooking> displaytrip() {
		return tripBookingserviceimpl.viewAllTripCustomer();
	}

	@DeleteMapping("/deletetrip{id}")
	public void del(int tripbookingid) {
		tripBookingserviceimpl.deleteTripBooking(tripbookingid);
	}

	@PutMapping("/updated")
	public void updatetrip(@RequestBody Tripbooking tripbooking) {
		tripBookingserviceimpl.updateTripBooking(tripbooking);
	}

	@GetMapping("/bill{cutomerid}")
	public float calbill(@PathVariable int cutomerid) {
		return tripBookingserviceimpl.calculatrBill(cutomerid);
	}
}
