package com.example.demo.RestApiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Cabre;
import com.example.demo.ServiceImplementation.CabRegistrationImpl;

@RestController
public class CabRegistrationController {

	@Autowired
	CabRegistrationImpl registration;
	
	@PostMapping("/save")
	public void ADDdata(@RequestBody Cabre CabRegistration)
	{
		registration.AddCab(CabRegistration);
		
	}
	@GetMapping("displaydata") //localhost:8099/displaydata?CabType=ola for API
	@ResponseBody
	public List<Cabre> showdata(@RequestParam(required = false) String CabType)
	{
		return registration.ViewCabOfType(CabType);
	}
	@PutMapping("update")
	public void updatedata(@RequestBody  Cabre cabRegistrration)
	{
		registration.AddCab(cabRegistrration);
	}
	
	@DeleteMapping("/delte{id}")
	public void delete(@PathVariable int id)
	{
		registration.DeleteCabById(id);
	}
	@GetMapping("/displayall")
	public List<Cabre> printall()
	{
		return registration.Displayall();
	}
	@GetMapping("/countoftype") //localhost:8099/countoftype?carType=iritka
	public int cabtype(@RequestParam String carType)
	{
		return registration.cabOfCountType(carType);
	}
}
