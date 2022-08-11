package com.example.demo.repository;
import java.util.Collection;
import com.example.demo.entities.Person;


public interface PersonDao {
	Collection<Person> getPeople();
	Person getPersonById(int id);
	void deletepersonById(int id);
	void addPerson(Person p);
	void updatePerson(Person p);
}
