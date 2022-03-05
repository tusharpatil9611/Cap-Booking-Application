package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Cabre;

public interface CabRegistrationService {

	public void AddCab(Cabre cabRegistration );

	public void UpdateCabCab(Cabre cabRegistration );
	public void DeleteCabById(int CabId);
	public List<Cabre> ViewCabOfType(String CarType);
	public List<Cabre> Displayall();
	public int cabOfCountType( String carType);
	
	
	
}
