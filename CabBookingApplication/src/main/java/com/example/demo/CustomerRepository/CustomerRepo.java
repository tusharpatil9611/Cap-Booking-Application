package com.example.demo.CustomerRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.CustomerEntity.Customer;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
