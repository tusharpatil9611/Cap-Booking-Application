package com.example.demo.ServiceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Cabre;
import com.example.demo.Repository.CabRegistratonRepository;
import com.example.demo.Service.CabRegistrationService;

@Service
public class CabRegistrationImpl implements CabRegistrationService{

	@Autowired
	CabRegistratonRepository repo;
	@Override
	public void AddCab(Cabre cabRegistration) {
		// TODO Auto-generated method stub
		repo.save(cabRegistration);
	}

	@Override
	public void UpdateCabCab(Cabre cabRegistration) {
		// TODO Auto-generated method stub
		 repo.save(cabRegistration);
	}

	@Override
	public void DeleteCabById(int CabId) {
		// TODO Auto-generated method stub
		System.out.println(CabId);
		repo.deleteById(CabId);
	}

	@Override
	public List<Cabre> ViewCabOfType(String CarType) {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Cabre> Displayall() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public int cabOfCountType(String carType) {
		// TODO Auto-generated method stub
		
		List<Cabre> list1=repo.findAll().stream().filter(x->x.getCartype().equals(carType)).collect(Collectors.toList());
		int size=list1.size();
		System.out.println(size);

		System.out.println(list1);
		return size;
	}

}
