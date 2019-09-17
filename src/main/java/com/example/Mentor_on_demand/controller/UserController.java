package com.example.Mentor_on_demand.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mentor_on_demand.model.Technologies;
import com.example.Mentor_on_demand.model.Trainings;
import com.example.Mentor_on_demand.model.User;
import com.example.Mentor_on_demand.repo.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api1")
public class UserController {

	@Autowired
	UserRepository userrepo;
	
	
	
	
	


	@GetMapping("/sample")
	public int sample() {
		System.out.println("fetched sample..");
		return 1;
	}

	@PostMapping(value = "/create")
	public User registerUser(@RequestBody User user) {
		System.out.println("hiiiiii");


		// new
		// User(user.getUsername(),user.getPassword(),user.getFirstname(),user.getLastname(),user.getContact_number(),user.getReg_datetime(),user.getReg_code(),user.getActive())
		User _user = userrepo.save(user);
		return _user;

	}
	
	@GetMapping("/search/{name}/{start_time}")
	public List<Technologies> searchTrainings(@PathVariable ("name") String name,@PathVariable ("start_time") String start_time)
	{
		System.out.println("hh");
		List<Technologies> _technologies=new ArrayList<Technologies>();
				userrepo.findTechnologies(name,start_time).forEach(_technologies::add);
		System.out.println(_technologies.get(0));
		return _technologies;
	}
	
	@GetMapping("/userLanding")
	public List<Technologies> viewTechnologies()
	{
		List<Technologies> _technologies=userrepo.findAllTechnologies();
		return _technologies;
	}
	
	
	@GetMapping("/login/{username}/{password}")
	public User checkUser(@PathVariable ("username") String username,@PathVariable ("password") String password)
	{
		System.out.println("login");
		User _user=userrepo.findUser(username,password);
		System.out.println("login");
		return _user;
	}
	

}
