package com.example.demo.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.CustomerEntity.Customer;

@Controller
public class customercontroller {

	@Autowired
	CustomerRepo customerRepo;
	@PostMapping("/customer")
	public String insert(Model model ,Customer customer ) 
	{
		customerRepo.save(customer);
		return "customeradd";
		
	}
}
