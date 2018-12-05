package com.healthhood.HealthHood.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.healthhood.HealthHood.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByEmail(String email);


}
