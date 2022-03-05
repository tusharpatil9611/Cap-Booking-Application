package com.example.demo.Entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private int driverid;
   private String licenceNo;
   private float rating;
   @OneToOne(cascade = CascadeType.ALL,orphanRemoval =true )
   public Cabre cabRegistrration;
public int getDriverid() {
	return driverid;
}
public void setDriverid(int driverid) {
	this.driverid = driverid;
}
public String getLicenceNo() {
	return licenceNo;
}
public void setLicenceNo(String licenceNo) {
	this.licenceNo = licenceNo;
}
public float getRating() {
	return rating;
}
public void setRating(float rating) {
	this.rating = rating;
}
public Cabre getCabRegistrration() {
	return cabRegistrration;
}
public void setCabRegistrration(Cabre cabRegistrration) {
	this.cabRegistrration = cabRegistrration;
}
@Override
public String toString() {
	return "Driver [driverid=" + driverid + ", licenceNo=" + licenceNo + ", rating=" + rating + ", cabRegistrration="
			+ cabRegistrration + "]";
}
public Driver(int driverid, String licenceNo, float rating, Cabre cabRegistrration) {
	super();
	this.driverid = driverid;
	this.licenceNo = licenceNo;
	this.rating = rating;
	this.cabRegistrration = cabRegistrration;
}
public Driver() {
	super();
	// TODO Auto-generated constructor stub
}
  
	
	
}
