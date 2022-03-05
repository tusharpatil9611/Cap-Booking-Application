package com.example.demo.UiController;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.Cabre;
import com.example.demo.Entity.Driver;
import com.example.demo.ServiceImplementation.CabRegistrationImpl;
import com.example.demo.ServiceImplementation.DriverServiceImpl;

@Controller
public class DriverUiController {

	@Autowired
	private DriverServiceImpl driverimpl;
	@Autowired
	private CabRegistrationImpl cabregistration;

	@GetMapping("/home") // loading home page
	public String homepage() {
		try {
			return "Home";
		} catch (Exception e) {
			e.printStackTrace();
			return "Invalid Url";
		}
	}

	@GetMapping("/bestDriverList") // for admin
	public String bestDriver(Model model) {
		try {
			List<Driver> list = driverimpl.ViewBestDriver();
			// List<Cabre> list1=cabregistration.Displayall();
			model.addAttribute("bestdriverkey", list);
			// model.addAttribute("all", list1);

			return "bestDriverDisplay";
		} catch (Exception e) {
			e.printStackTrace();
			return "somthing went wrong";
		}
	}
	
	
	
	@GetMapping("/bestDriverList1")// best driver for customer
	public String bestDriver1(Model model) {
		try {
			List<Driver> list1 = driverimpl.ViewBestDriver();
			// List<Cabre> list1=cabregistration.Displayall();
			model.addAttribute("bestdriverkey1", list1);
			// model.addAttribute("all", list1);

			return "bestdriverforcustomer";
		} catch (Exception e) {
			e.printStackTrace();
			return "somthing went wrong";
		}
	}
	
	

	@GetMapping("/getform") // load driver form
	public String loadform(Model model) {
		try {
			Driver driver = new Driver();
			Cabre c = new Cabre();
			model.addAttribute("driver", driver);
			model.addAttribute("cab", c);
			return "DriverForm";
		} catch (Exception e) {
			e.printStackTrace();
			return "please try to load once again";
		}
	}

	@PostMapping("/storedata") // save driver 
	public String Addrecord(Model model, @ModelAttribute("driver") Driver driver1, @ModelAttribute("cab") Cabre c) {
		try {

			System.out.println(driver1);
			System.out.println(c);
			cabregistration.AddCab(c);

			driverimpl.InsertDriver(driver1);
			return "redirect:/getform";
		} catch (Exception e) {
			e.printStackTrace();
			return "record not found";
		}
	}

	@GetMapping("/delete1{id}") // delete driver
	public String deletedriver1(@PathVariable int id) {
		try {
			driverimpl.DeleteDriver(id);
			return "redirect:/alldriverlist";
		} catch (Exception e) {
			e.printStackTrace();
			return "Invalid Id";
		}
	}

	@GetMapping("/alldriverlist")
	public String printall(Model model) {
		try {
			List<Driver> d = driverimpl.showAllDriver();
			model.addAttribute("obj", d);

			return "DriverList";
		} catch (Exception e) {
			e.printStackTrace();
			return "Driver Not Present";
		}

	}
	
}
