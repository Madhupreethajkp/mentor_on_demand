package com.example.Mentor_on_demand.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mentor_on_demand.model.Mentor;
import com.example.Mentor_on_demand.model.User;
import com.example.Mentor_on_demand.repo.MentorRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/mentor")
public class MentorController {

	
	@Autowired
	MentorRepository mentorrepo;
	
	@PostMapping(value = "/create")
	public Mentor registerUser(@RequestBody Mentor mentor) {
		System.out.println("hiiiiii");
        mentor.setActive(true);
        
        mentor.setReg_code("mentor");
        

		// new
		// User(user.getUsername(),user.getPassword(),user.getFirstname(),user.getLastname(),user.getContact_number(),user.getReg_datetime(),user.getReg_code(),user.getActive())
		Mentor _mentor = mentorrepo.save(mentor);
		return _mentor;

	}
	
	@GetMapping("/login/{username}/{password}")
	public Mentor checkUser(@PathVariable ("username") String username,@PathVariable ("password") String password)
	{
		System.out.println("login");
		Mentor _mentor=mentorrepo.findMentor(username,password);
		System.out.println("login");
		return _mentor;
	}
	
	@GetMapping(value = "/fetchMentorProfile/{mentor}")
	public Mentor fetchMentorProfile(@PathVariable ("mentor") String mentor) {
		System.out.println(mentor);
		Mentor mentorName=mentorrepo.findMentorProfile(mentor);
		System.out.println(mentorName.getContact_number());
		return mentorName;

		
	}
}
