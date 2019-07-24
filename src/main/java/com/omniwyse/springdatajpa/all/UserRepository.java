package com.omniwyse.springdatajpa.all;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Emp, Long> {
	
	
}