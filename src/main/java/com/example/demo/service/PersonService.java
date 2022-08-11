package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Person;
import com.example.demo.repository.PersonDao;

@Service
public class PersonService {
	@Autowired
	private PersonDao repository;
	
	public Collection<Person> allPeople(){
		Collection<Person> people = repository.getPeople();
		System.out.println("***** " + people.size());
		return people;
	}
	
	public Person personById(int id) {
		return repository.getPersonById(id);
	}
	
	public void addPerson(Person p) {
		repository.addPerson(p);
	}
	
	public void updatePerson(Person p) {
		repository.updatePerson(p);
	}
	
	public void deletePerson(int id) {
		repository.deletepersonById(id);
	}
}
