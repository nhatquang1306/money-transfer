package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import com.techelevator.movies.model.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcGenreDao implements GenreDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcGenreDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Genre> getGenres() {
        List<Genre> genreList = new ArrayList<>();
        String sql = "Select * From genre;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()) {
            Genre genre = new Genre();
            genre.setId(result.getInt("genre_id"));
            genre.setName(result.getString("genre_name"));
            genreList.add(genre);
        }
        return genreList;
    }


    @Override
    public Genre getGenreById(int id) {
            Genre genre = new Genre();
            String sql = "Select * From genre WHERE genre_id = ?;";
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
            if (result.next()) {
                genre.setId(result.getInt("genre_id"));
                genre.setName(result.getString("genre_name"));
            } else {
                return null;
            }
            return genre;
        }

    @Override
    public List<Genre> getGenresByName(String name, boolean useWildCard) {
        List<Genre> genreList = new ArrayList<>();
        String sql = "Select * From genre WHERE genre_name ILIKE ?;";
        if (useWildCard) {
            name = "%" + name + "%";
        }
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, name);
        while (result.next()) {
            Genre genre = new Genre();
            genre.setId(result.getInt("genre_id"));
            genre.setName(result.getString("genre_name"));
            genreList.add(genre);
        }
        return genreList;
    }
}
