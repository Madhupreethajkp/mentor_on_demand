package com.example.Mentor_on_demand.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.Mentor_on_demand.model.MentorSkills;

public interface SkillsRepository extends CrudRepository<MentorSkills, Long> {

	
	
	@Query("Select c From MentorSkills c where c.skill_name = :skill_name")
	Optional<MentorSkills> findBySkill_name(String skill_name);

}
