package com.example.Mentor_on_demand.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mentor_on_demand.model.MentorSkills;
import com.example.Mentor_on_demand.model.Trainings;
import com.example.Mentor_on_demand.repo.SkillsRepository;

@CrossOrigin(origins = "http://localhost:4203")
@RestController
@RequestMapping("/api")
public class SkillsController {
	
	@Autowired
	SkillsRepository skillsrepo;
	
	
	@GetMapping(value = "skillss/{id}")
	public Optional<MentorSkills> getTrainingsdetail(@PathVariable long id) {
		
		Optional<MentorSkills> skills = skillsrepo.findById(id);
		return skills;
	    

	}
	
	@GetMapping(value = "skillss/{skill_name}")
	public Optional<MentorSkills> getTrainingsdetail(@PathVariable String skill_name) {
		
		Optional<MentorSkills> skills = skillsrepo.findBySkill_name(skill_name);
		return skills;
	    

	}
	
	
	
	

}
