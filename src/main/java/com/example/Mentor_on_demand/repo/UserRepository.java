package com.example.Mentor_on_demand.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.Mentor_on_demand.model.Technologies;
import com.example.Mentor_on_demand.model.Trainings;
import com.example.Mentor_on_demand.model.User;

public interface UserRepository extends CrudRepository<User,Long> {

	@Query("Select c From Technologies c where c.name = :name and c.start_time = :start_time")
	List<Technologies> findTechnologies(@Param("name") String name,@Param("start_time") String start_time);
	
	@Query( "Select c From Technologies c")
	List<Technologies> findAllTechnologies();

	
	@Query("Select c From User c where c.id = :id and c.password = :password")
	User findById(Long id, String password);

	@Query("Select c From User c where c.username = :username and c.password = :password")
	User findUser(String username, String password);

	
}
