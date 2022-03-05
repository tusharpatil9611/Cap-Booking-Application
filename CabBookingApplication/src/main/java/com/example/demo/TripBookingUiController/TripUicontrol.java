package com.example.demo.TripBookingUiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.Cabre;
import com.example.demo.Entity.Driver;
import com.example.demo.ServiceImplementation.CabRegistrationImpl;
import com.example.demo.ServiceImplementation.DriverServiceImpl;
import com.example.demo.TripBookingEntity.Tripbooking;
import com.example.demo.TripBookingserviceimpl.TripBookingserviceimpl;

@Controller
public class TripUicontrol {

	@Autowired
	private TripBookingserviceimpl tripBookingserviceimpl;
	@Autowired
	DriverServiceImpl driverServiceImpl;
	@Autowired
	CabRegistrationImpl cabRegistrationImpl;

	/*
	 * @GetMapping("/customerhome")
	 * 
	 * public String gethome() { return "CustomerHome"; }
	 */

	@GetMapping("/gettripform") // load empty trip form
	public String gettrip(Model model, Tripbooking tripbooking) {
		
		List<Driver> d=driverServiceImpl.showAllDriver();
		List<Cabre>  c=cabRegistrationImpl.Displayall();
		
		model.addAttribute("dobj", d);
		model.addAttribute("trip", tripbooking);
		System.out.println(c);
		model.addAttribute("ca", c);
		return "TripBooking";
	}

	@PostMapping("/saveform") // save trip form
	public String savedata(Model model, @ModelAttribute("trip") Tripbooking tripbooking) {
		tripBookingserviceimpl.insertTripBooking(tripbooking);
		return "redirect:/gettripform";
	}

	@GetMapping("/viewAllTripCustomer") // view all trip in admin
	public String viewdrive(Model model) {
		List<Tripbooking> list = tripBookingserviceimpl.viewAllTripCustomer();
		model.addAttribute("trip_booking", list);
		System.out.println(list.size());
		return "ViewTripBooking";
	}
	@GetMapping("/del1{id}")
	public String deleteTripBooking1(@PathVariable int id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		tripBookingserviceimpl.deleteTripBooking(id);
		return "redirect:/viewAllTripCustomer";
	}
	
	
	
	
	@GetMapping("/viewBookingfordriver") // view all trip in admin
	public String viewdrive1(Model model) {
		List<Tripbooking> list1 = tripBookingserviceimpl.viewAllTripCustomer();
		model.addAttribute("trip_booking1", list1);
		System.out.println(list1.size());
		return "viewtripfordriver";
	}

}
