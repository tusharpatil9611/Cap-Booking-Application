package com.example.demo.RestApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Cabre;
import com.example.demo.Entity.Driver;
import com.example.demo.ServiceImplementation.CabRegistrationImpl;
import com.example.demo.ServiceImplementation.DriverServiceImpl;

@RestController
public class DriverController {

	@Autowired
	DriverServiceImpl driverServiceImpl;
	@Autowired
	CabRegistrationImpl impl;
	@PostMapping("/savedriver") //localhost:8099/savedriver
	public void insertdriver(@RequestBody Driver driver)
	{
		 driverServiceImpl.InsertDriver(driver);
		
	}
	
	@GetMapping("/displaydriver")
	public List<Driver> showdriver()
	{
		return  driverServiceImpl.ViewBestDriver();
	
	}
	
	@GetMapping("/displayBestDriver{id}")
	public Driver printmy(@PathVariable int id)
	{
		return  driverServiceImpl.ViewDriver(id);
	}
	@PutMapping("/updatedriver")
	public void updatedriver(@RequestBody Driver driver)
	{
		driverServiceImpl.UpdateDriver(driver);
	}
	
	@DeleteMapping("/delete{id}")
	public void deletedriver(@PathVariable int id)
	{
   		
		driverServiceImpl.DeleteDriver(id);
	}
	@GetMapping("/alldriver")
	public List<Driver> printall()
	{
		return driverServiceImpl.showAllDriver();
	}
	
}
