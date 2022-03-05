package com.example.demo.TripBookingRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.TripBookingEntity.Tripbooking;

@Repository
public interface Tripbookingrepo extends JpaRepository<Tripbooking, Integer>{

}
