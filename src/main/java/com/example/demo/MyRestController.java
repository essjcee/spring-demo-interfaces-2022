package com.example.demo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Person;
import com.example.demo.service.PersonService;

@RestController
@CrossOrigin
public class MyRestController {
	@Autowired
	PersonService service;
	
	@GetMapping(value="/people")
	public Collection<Person> getPeople(){
		return service.allPeople();
	}
	
	@GetMapping(value="/people/{id}")
	public Person getPeople(@PathVariable("id") int id){
		return service.personById(id);
	}
	
	@DeleteMapping(value="/people/{id}")
	public void deletePerson(@PathVariable("id") int id){
		service.deletePerson(id);
	}
	
	@PostMapping(value="/people)")
	public void addPerson(@RequestBody Person p) {
		service.addPerson(p);
	}
	
	@PutMapping(value="/people)")
	public void updatePerson(@RequestBody Person p) {
		service.updatePerson(p);
	}

}
