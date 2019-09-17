package com.example.Mentor_on_demand.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.Mentor_on_demand.model.Mentor;
import com.example.Mentor_on_demand.model.Technologies;
import com.example.Mentor_on_demand.model.User;


public interface TechnologiesRepository extends CrudRepository<Technologies, Long> {

	
	@Query("Select c.username From Mentor c where c.id = :id")
	String findMentor(Long id);
	
	
}
