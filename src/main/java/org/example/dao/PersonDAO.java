package org.example.dao;

import org.example.models.Book;
import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index(){
       return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id){
        return jdbcTemplate.query("SELECT * FROM person WHERE person_id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void create(Person person){
        jdbcTemplate.update("INSERT INTO person(fullname, age) VALUES (?,?)",
                person.getFullName(), person.getAge());
    }

    public void update(int id, Person person){
        jdbcTemplate.update("UPDATE person SET fullname=?, age=? WHERE person_id=?",
                person.getFullName(), person.getAge(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM person WHERE person_id=?", id);
    }

    public List<Book> haveBook(int id){
        return jdbcTemplate.query("SELECT book.* FROM book JOIN person ON person.person_id = book.person_id " +
                        "WHERE book.person_id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }
}
