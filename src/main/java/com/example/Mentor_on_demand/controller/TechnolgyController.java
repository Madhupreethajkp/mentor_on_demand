package com.example.Mentor_on_demand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mentor_on_demand.model.Technologies;
import com.example.Mentor_on_demand.model.Trainings;
import com.example.Mentor_on_demand.repo.TechnologiesRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tech")
public class TechnolgyController {
	
	@Autowired
	TechnologiesRepository techrepo;
	
	@PostMapping(value = "/fetchMentor")
	public String fetchMentor(@RequestBody Technologies technology) {
		
		Long mentor=technology.getMentor_id();
		String mentor1=techrepo.findMentor(mentor);
		return mentor1;

		
	}
	
	

}
