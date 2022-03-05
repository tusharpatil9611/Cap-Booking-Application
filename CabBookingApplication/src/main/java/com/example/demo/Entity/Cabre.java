package com.example.demo.Entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cabre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	public int cabid;
	
	public String cartype;
	public float perkmrate;
	
	public int getCabid() {
		return cabid;
	}
	public void setCabid(int cabid) {
		this.cabid = cabid;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public float getPerkmrate() {
		return perkmrate;
	}
	public void setPerkmrate(float perkmrate) {
		this.perkmrate = perkmrate;
	}
	public Cabre(int cabid, String cartype, float perkmrate) {
		super();
		this.cabid = cabid;
		this.cartype = cartype;
		this.perkmrate = perkmrate;
	}
	public Cabre() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Cabre [cabid=" + cabid + ", cartype=" + cartype + ", perkmrate=" + perkmrate + "]";
	}

	
}
