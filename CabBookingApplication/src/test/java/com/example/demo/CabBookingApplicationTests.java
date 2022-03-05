package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.Cabre;
import com.example.demo.Entity.Driver;
import com.example.demo.Repository.DriverRepository;
import com.example.demo.ServiceImplementation.CabRegistrationImpl;
import com.example.demo.ServiceImplementation.DriverServiceImpl;
import com.example.demo.TripBookingEntity.Tripbooking;
import com.example.demo.TripBookingRepository.Tripbookingrepo;
import com.example.demo.TripBookingserviceimpl.TripBookingserviceimpl;
import com.example.demo.security.Admin;
import com.example.demo.security.AdminRepository;

@SpringBootTest
class CabBookingApplicationTests {

	@Autowired
	CabRegistrationImpl cabRegistrationImpl;// object of cab implementaion
	@Autowired
	DriverServiceImpl deriverimpl; // object of driver implementaion
   @Autowired
    TripBookingserviceimpl tripbookingimpl; //object of tripimpl
   @Autowired
	public AdminRepository adminRepository;
   @Autowired
   Tripbookingrepo tripbookingrepo;
   @Autowired
    DriverRepository driverRepository;
	@Test
	void contextLoads() {

	}

	@Test
	public void DisplayCab() // display
	{
		assertThat(cabRegistrationImpl.Displayall()).isNotEqualTo(0);
	}

	@Test
	public void DisplayDriver() // display driver
	{
		assertThat(deriverimpl.showAllDriver()).isNotEqualTo(0);
	}

	@Test
	public void Adddriver() // add driver
	{
		Driver d = new Driver();
		d.setDriverid(1);
		d.setLicenceNo("magh");
		d.setRating(4.5F);
		Cabre c = new Cabre();
		c.setCabid(1);
		c.setCartype("swift");
		c.setPerkmrate(11.0F);
		d.setCabRegistrration(c);
		deriverimpl.InsertDriver(d);
		assertThat(d.getDriverid()).isGreaterThan(0);

	}

	@Test
	public void AddCab() // add cab
	{
		Cabre c = new Cabre();
		c.setCabid(1);
		c.setCartype("swift");
		c.setPerkmrate(11.0F);
		cabRegistrationImpl.AddCab(c);
		assertThat(c.getCabid()).isGreaterThan(0);
	}
    @Test
	public void bestDriver() // viewing best driver
	{
		assertThat(deriverimpl.ViewBestDriver()).isNotEqualTo(-1);
	}

	@Test
	public void counttype() // return count of same cab 
	{
		assertThat(cabRegistrationImpl.cabOfCountType("swift")).isNotEqualTo(-1);
	}
	
	@Test
	public void Addtrip() // register trip book
	{
		Tripbooking t=new Tripbooking();
		t.setCutomerid(1);
		tripbookingimpl.insertTripBooking(t);
		assertThat(t.getCutomerid()).isGreaterThan(0);
	}
	
	@Test
	public void displayTrip()
	{
		assertThat(tripbookingimpl.viewAllTripCustomer()).isNotEqualTo(-1);
	}
	
	
	  @Test 
	  public void registerUser() // create user
	  {
		  Admin a=new Admin();
		  a.setUsername("hanmant");
	  
		
		  assertThat(adminRepository.save(a)).isNotEqualTo(-1);
	  
	  }
	  
	  @Test
	  public void deleteFromRepository() // delete from repository
	  {
		  driverRepository.deleteById(88);
		  assertThat(driverRepository.existsById(88)).isFalse();
	  }
	  
	  
	  
	  
	  @Test
	  public void deleteFromImpl() // delete from Implementaion
	  {
		  deriverimpl.DeleteDriver(83);
		  assertThat(driverRepository.existsById(83)).isFalse();
	  }
	  
		
}
		
	 	 

