package com.example.demo.TripBookingEntity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.Entity.Driver;

@Entity
public class Tripbooking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tripbookingid;
	private int cutomerid;
	private String fromlocation;
	private String tolocation;
	private String fromdatetime;
	private String todatetime;
	private boolean status;
	private float distanceinkm;
	private float bill;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Driver driver;
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public int getTripbookingid() {
		return tripbookingid;
	}
	public void setTripbookingid(int tripbookingid) {
		this.tripbookingid = tripbookingid;
	}
	public int getCutomerid() {
		return cutomerid;
	}
	public void setCutomerid(int cutomerid) {
		this.cutomerid = cutomerid;
	}
	public String getFromlocation() {
		return fromlocation;
	}
	public void setFromlocation(String fromlocation) {
		this.fromlocation = fromlocation;
	}
	public String getTolocation() {
		return tolocation;
	}
	public void setTolocation(String tolocation) {
		this.tolocation = tolocation;
	}
	public String getFromdatetime() {
		return fromdatetime;
	}
	public void setFromdatetime(String fromdatetime) {
		this.fromdatetime = fromdatetime;
	}
	public String getTodatetime() {
		return todatetime;
	}
	public void setTodatetime(String todatetime) {
		this.todatetime = todatetime;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public float getDistanceinkm() {
		return distanceinkm;
	}
	public void setDistanceinkm(float distanceinkm) {
		this.distanceinkm = distanceinkm;
	}
	public float getBill() {
		return bill;
	}
	public void setBill(float bill) {
		this.bill = bill;
	}
	public Tripbooking(int tripbookingid, int cutomerid, String fromlocation, String tolocation, String fromdatetime,
			String todatetime, boolean status, float distanceinkm, float bill) {
		super();
		this.tripbookingid = tripbookingid;
		this.cutomerid = cutomerid;
		this.fromlocation = fromlocation;
		this.tolocation = tolocation;
		this.fromdatetime = fromdatetime;
		this.todatetime = todatetime;
		this.status = status;
		this.distanceinkm = distanceinkm;
		this.bill = bill;
	}
	public Tripbooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Tripbooking [tripbookingid=" + tripbookingid + ", cutomerid=" + cutomerid + ", fromlocation="
				+ fromlocation + ", tolocation=" + tolocation + ", fromdatetime=" + fromdatetime + ", todatetime="
				+ todatetime + ", status=" + status + ", distanceinkm=" + distanceinkm + ", bill=" + bill + "]";
	}
	
	
}
