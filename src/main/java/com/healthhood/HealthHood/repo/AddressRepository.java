package com.healthhood.HealthHood.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.healthhood.HealthHood.Entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	
	Address findByUserid(String userid);


}
