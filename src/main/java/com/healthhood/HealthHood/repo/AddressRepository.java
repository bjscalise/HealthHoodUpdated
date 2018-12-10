package com.healthhood.HealthHood.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthhood.HealthHood.Entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	
	List<Address> findByUserid(Integer userid);


}
