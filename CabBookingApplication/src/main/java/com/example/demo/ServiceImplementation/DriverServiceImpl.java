package com.example.demo.ServiceImplementation;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Driver;
import com.example.demo.Repository.DriverRepository;
import com.example.demo.Service.DriverService;
@Service
public class DriverServiceImpl implements DriverService{
    @Autowired
   private DriverRepository driverRepository;
	
	@Override
	public void InsertDriver(Driver driver) {
		// TODO Auto-generated method stub
		driverRepository.save(driver);
	}

	@Override
	public void UpdateDriver(Driver driver) {
		// TODO Auto-generated method stub
		driverRepository.save(driver);
	}

	@Override
	public void DeleteDriver(int driverid) {
		// TODO Auto-generated method stub
		driverRepository.deleteById(driverid);
	}

	@Override
	public List<Driver> ViewBestDriver() {
		// TODO Auto-generated method stub


		return  driverRepository.findAll().stream().filter(x->x.getRating()>4.5).collect(Collectors.toList());
		
		
	}

	@Override
	public Driver ViewDriver(int driverid) {
		// TODO Auto-generated method stub
		return driverRepository.findById(driverid).get();
	}

	@Override
	public List<Driver> showAllDriver() {
		// TODO Auto-generated method stub
		return driverRepository.findAll();
	}

	

}
