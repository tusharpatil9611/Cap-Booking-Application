package com.example.demo.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Entity.Cabre;
import com.example.demo.Entity.Driver;
import com.example.demo.ServiceImplementation.CabRegistrationImpl;
import com.example.demo.ServiceImplementation.DriverServiceImpl;
import com.example.demo.TripBookingEntity.Tripbooking;

@Controller
public class Admincontroller {
	@Autowired
	public AdminRepository adminRepository;
	@Autowired
	DriverServiceImpl driverServiceImpl;
	@Autowired
	CabRegistrationImpl impl;
	

	@GetMapping("/Adminhome1") // user Home Page
	public String home() {
		return "AdminHome";
	}

	@GetMapping("/register") // for register for login
	public String singup(Model model) {

		model.addAttribute("admin", new Admin());
		return "AdminSignup";
	}

	@PostMapping("/stddata") // save registration
	public String storedatam(Model model, Admin admin) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(admin.getPassword());
		admin.setPassword(encodedPassword);
		adminRepository.save(admin);
		return "redirect:/Adminhome1";
	}

	@GetMapping("/demo")
	public String demo() {
		return "Demo";
	}

	@GetMapping("/aboutus") // about us
	public String about() {
		return "AboutUs";
	}

	@GetMapping("/gettripform1") // get trip for login
	public String gettrip(Model model, Tripbooking tripbooking) {
		model.addAttribute("trip", tripbooking);
		List<Driver> d = driverServiceImpl.showAllDriver();
		System.out.println(d);
		model.addAttribute("dobj", d);
		return "TripBooking";
	}

	@GetMapping("/customerhome1")
	public String chome(Model model) {

		return "CustomerHome";
	}

	@GetMapping("/allCablist1") // display all cab user
	public String printal(Model model) {
		try {
			List<Cabre> l3 = impl.Displayall();
			model.addAttribute("cab1", l3);
			return "Cablistuser";
		} catch (Exception e) {
			e.printStackTrace();
			return "Cab Not Available";
		}

	}
	
	@GetMapping("/driverhome")
	public String getdriver()
	{
		return "DriverHome";
	}
	
}
