package com.example.Mentor_on_demand.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.Mentor_on_demand.model.Admin;
import com.example.Mentor_on_demand.model.User;

public interface AdminRepository extends CrudRepository<Admin, Long> {
	
	@Query("Select c From Admin c where c.username = :username and c.password = :password")
	Admin findUser(String username, String password);

}
