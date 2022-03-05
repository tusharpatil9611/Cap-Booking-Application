package com.example.demo.Service;

import java.util.List;
import java.util.stream.Stream;

import com.example.demo.Entity.Driver;

public interface DriverService {

	public void InsertDriver(Driver driver );
    public void UpdateDriver(Driver driver );
	public void DeleteDriver(int driverid);
	public List<Driver> ViewBestDriver();
	public Driver ViewDriver(int driverid);
	public List<Driver> showAllDriver();
	
}
