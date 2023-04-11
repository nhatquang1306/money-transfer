package com.techelevator.movies.dao;

import com.techelevator.movies.model.Movie;
import com.techelevator.movies.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDao implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    private static Person mapToPerson(SqlRowSet result) throws NullPointerException {
        Person person = new Person();
        person.setId(result.getInt("person_id"));
        person.setName(result.getString("person_name"));
        try {
            person.setBirthday(result.getDate("birthday").toLocalDate());
            person.setDeathDate(result.getDate("deathday").toLocalDate());
        } catch (NullPointerException e) {
            e.getMessage();
        }
        person.setBiography(result.getString("biography"));
        person.setProfilePath(result.getString("profile_path"));
        person.setHomePage(result.getString("home_page"));

        return person;
    }

    public JdbcPersonDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Person> getPersons() {
        List<Person> personList = new ArrayList<>();
        String sql = "Select * From person;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()) {
            personList.add(mapToPerson(result));
        }
        return personList;
    }

    @Override
    public Person getPersonById(int id) {
        Person person = new Person();
        String sql = "Select * From person WHERE person_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if (result.next()) {
            person = (mapToPerson(result));
        }else {
            return null;
        }
        return person;
    }

    @Override
    public List<Person> getPersonsByName(String name, boolean useWildCard) {
        List<Person> personByName = new ArrayList<>();
        String sql = "Select * From person WHERE person_name ILIKE ?;";
        if (useWildCard) {
            name = "%" + name + "%";
        }
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,name);
        while (result.next()) {
            Person person = (mapToPerson(result));
            personByName.add(person);
        }
        return personByName;
    }


    @Override
    public List<Person> getPersonsByCollectionName(String collectionName, boolean useWildCard) {
        List<Person> personList = new ArrayList<>();
        String sql = "SELECT DISTINCT person_id, person_name, birthday, deathday, biography, profile_path, person.home_page From person JOIN movie_actor ON movie_actor.actor_id = person.person_id JOIN movie ON movie.movie_id = movie_actor.movie_id JOIN collection ON collection.collection_id = movie.collection_id WHERE collection_name ILIKE ?;";
        if (useWildCard) {
            collectionName = "%" + collectionName + "%";
        }
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, collectionName);
        while (result.next()) {
            personList.add(mapToPerson(result));
        }
        return personList;
    }
}
