package com.example.demo.repository;

import java.util.Collection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Person;

@Repository
@Primary
public class MySQLRepository implements PersonDao {

	@Autowired
	JdbcTemplate template;
	
	@Override
	public Collection<Person> getPeople() {
		String sql = "SELECT id, name, age FROM people";
		return template.query(sql, new PersonRowMapper());
	}

	@Override
	public Person getPersonById(int id) {
		String sql = "SELECT id, name, age FROM people WHERE id = ?";
		return template.queryForObject(sql, new PersonRowMapper(), id);
		
	}

	@Override
	public void deletepersonById(int id) {
		String sql = "DELETE FROM people WHERE id = ?";
		template.update(sql,id);
	}

	@Override
	public void addPerson(Person p) {
		String sql = "INSERT INTO people(name, age) " +
				"VALUES(?,?)";
		template.update(sql, p.getName(), p.getAge());
	}

	@Override
	public void updatePerson(Person p) {
		String sql = "UPDATE people SET name = ?, age = ? "
				+ "WHERE id = ?";
		template.update(sql, p.getName(), p.getAge(), p.getId());
	}

}

class PersonRowMapper implements RowMapper<Person>{

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new Person(
				rs.getInt("id"), 
				rs.getString("name"),
				rs.getInt("age"));
	}
	
}
