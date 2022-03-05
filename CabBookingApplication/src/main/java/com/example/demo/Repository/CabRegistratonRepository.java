package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Cabre;
@Repository
public interface CabRegistratonRepository extends JpaRepository<Cabre, Integer>{

}
