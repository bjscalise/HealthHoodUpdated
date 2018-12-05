package com.healthhood.HealthHood.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthhood.HealthHood.Entity.SavedSearch;

public interface SavedSearchRepository extends JpaRepository<SavedSearch, Integer> {
	
	List<SavedSearch> findByUserid(Integer userid);

}
