package com.example.Mentor_on_demand.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.Mentor_on_demand.model.Mentor;
import com.example.Mentor_on_demand.model.User;

public interface MentorRepository extends CrudRepository<Mentor, Long> {
	
	@Query("Select c From Mentor c where c.username = :username and c.password = :password")
	Mentor findMentor(String username, String password);

	@Query("Select c From Mentor c where c.username = :username")
	Mentor findMentorProfile(String username);
}
