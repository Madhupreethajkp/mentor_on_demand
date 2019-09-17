package com.example.Mentor_on_demand.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mentor_on_demand.model.Technologies;
import com.example.Mentor_on_demand.model.Trainings;
import com.example.Mentor_on_demand.repo.TechnologiesRepository;
import com.example.Mentor_on_demand.repo.TrainingsRepository;





@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TrainingsController {
	
	@Autowired
	TrainingsRepository trainingrepo;
	
	@Autowired
	TechnologiesRepository techrepo;
	
	
	
	
	@PostMapping(value = "/training/create/{user}")
	public Trainings createTraining(@RequestBody Technologies technology,@PathVariable ("user") String user) {

		System.out.println("inside create training");	
		Trainings _training=new Trainings();
		String MentorName=techrepo.findMentor(technology.getMentor_id());
		_training.setMentor_name(MentorName);
		_training.setUser_id("1");
		_training.setUsername(user);
		_training.setMentor_id(technology.getMentor_id());
		_training.setStatus("Proposed");
		_training.setTraining_name(technology.getName());
		trainingrepo.save(_training);
		
		
		return _training;
	}
	
	@PostMapping(value = "/create/{user}/{mentorName}")
	public Trainings createTraining(@RequestBody Technologies technology,@PathVariable ("user") String user,@PathVariable ("mentorName") String mentorName) {

		System.out.println("inside create training");	
		Trainings _training=new Trainings();
		Long mid=technology.getMentor_id();
		_training.setUser_id("1");
		_training.setUsername(user);
		_training.setMentor_id(technology.getMentor_id());
		_training.setStatus("Proposed");
		_training.setTraining_name(technology.getName());
		_training.setMentor_name(mentorName);
		trainingrepo.save(_training);
		
		
		return _training;
	}
	
	@GetMapping("/propose/{id}")
	public ResponseEntity<Trainings> changeToPropose(@PathVariable("id") long id, @RequestBody Trainings training) {
		
		System.out.println("inside propose");
		System.out.println("Update Trainings with id = " + id + "...");

		Optional<Trainings> trainingdata = trainingrepo.findById(id);

		if (trainingdata.isPresent()) {
			Trainings _training = trainingdata.get();
			_training.setStatus("proposed");
			return new ResponseEntity<>(trainingrepo.save(_training), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


@GetMapping("/trainingsCompleted")
public List<Trainings> getCompletedTrainings() {
	
    
	List<Trainings> trainings = new ArrayList<>();
	
	trainingrepo.findCompletedTrainings("completed");

	return trainings;
}
 
@GetMapping("/training/fetchProposed/{user}")
public List<Trainings> getProposedTrainings(@PathVariable("user") String username) {
	
    
	List<Trainings> trainings = new ArrayList<>();
	String status="proposed";
	trainings=trainingrepo.findProposedTrainings(status,username);

	return trainings;
}
@GetMapping("/training/fetchCompleted/{user}")
public List<Trainings> getCompletedTrainings(@PathVariable("user") String username) {
	
    
	List<Trainings> trainings = new ArrayList<>();
	String status="completed";
	trainings=trainingrepo.findProposedTrainings(status,username);

	return trainings;
}
@GetMapping("/trainingsUnderProcess")
public List<Trainings> geUnderProcessTrainings() {
	
    
	List<Trainings> trainings = new ArrayList<>();
	
	trainingrepo.findCompletedTrainings("underProcess");

	return trainings;
}

@GetMapping(value = "training/fetch/{user}")
public List<Trainings> getTrainingsdetail(@PathVariable String user) {
	
	List<Trainings> trainings = trainingrepo.findByName(user);
	return trainings;
    

}
@GetMapping(value = "training/fetchMentor/{mentor}")
public List<Trainings> getMentorTrainings(@PathVariable String mentor) {
	
	List<Trainings> trainings = trainingrepo.findByMentor(mentor);
	return trainings;
    

}

@GetMapping(value="allTrainings1")
public List<Trainings> allTraining()
{
	List<Trainings> _trainings=(List<Trainings>) trainingrepo.findAll();
	return _trainings;
}

@GetMapping(value="allTrainings")
public List<Technologies> allTrainings()
{
	List<Technologies> _trainings=(List<Technologies>) trainingrepo.findAllCourses();
	return _trainings;
}

@GetMapping("/getTrainingDetails/{id}")
public Optional<Trainings> getAllCustomersbyId(@PathVariable long id) {
	System.out.println("Get all trainings details...");

	
	Optional<Trainings> trainings=trainingrepo.findById(id);

	return trainings;
}
@GetMapping(value = "getTrainingsByStatus/{status}")
public List<Trainings> findByStatus(@PathVariable String status) {

	List<Trainings> trainings= trainingrepo.findByStatus(status);
	return trainings;
}

}
