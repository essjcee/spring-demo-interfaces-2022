package com.example.demo.repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.Person;

@Repository
public class MapRepository implements PersonDao{
	private static Map<Integer,Person> people = new HashMap<>();
	static {
		people.put(1, new Person(1, "Homer", 40));
		people.put(2, new Person(2, "Marge", 35));
		people.put(3, new Person(3, "Bart", 11));
		people.put(4, new Person(4, "Lisa", 8));
		people.put(5, new Person(5, "Maggie", 2));
	}
	
	@Override
	public Collection<Person> getPeople() {
		// TODO Auto-generated method stub
		return people.values();
	}

	@Override
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		return people.get(id);
	}

	@Override
	public void deletepersonById(int id) {
		people.remove(id);
	}

	@Override
	public void addPerson(Person p) {
		// TODO Auto-generated method stub
		people.put(p.getId(), p);
	}

	@Override
	public void updatePerson(Person p) {
		// TODO Auto-generated method stub
		if (people.containsKey(p.getId())) {
			people.put(p.getId(), p);
		}
	}

}
