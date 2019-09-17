package com.example.Mentor_on_demand.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.Mentor_on_demand.model.Technologies;
import com.example.Mentor_on_demand.model.Trainings;
import com.example.Mentor_on_demand.model.User;

public interface TrainingsRepository extends CrudRepository<Trainings, Long> {
	
	
	@Query("Select c From Trainings c where c.status = :status")
	Trainings findCompletedTrainings(@Param("status") String status);
	
	@Modifying
	@Transactional
	@Query("update Trainings c set c.status = :status where c.id = :id")
	List<Trainings> updateUserSetNameForAge(@Param("status") String status,  @Param("id") long id);
	
	List<Trainings> findByStatus(String status);

	
	@Query( "Select c From Technologies c")
	List<Technologies> findAllCourses();
	
	
	@Query("Select c From Trainings c where c.username = :username")
	List<Trainings> findByName(@Param("username") String username);

	@Query("Select c From Trainings c where c.status = :status and c.username=:username")
	List<Trainings> findProposedTrainings(@Param("status") String status,@Param("username") String username);
	
	
	@Query("Select c From Trainings c where c.mentor_name = :mentor_name")
	List<Trainings> findByMentor(@Param("mentor_name") String mentor_name);
	
	
	

}
