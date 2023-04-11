package com.techelevator.movies.dao;

import com.techelevator.movies.model.Genre;
import com.techelevator.movies.model.Movie;
import com.techelevator.movies.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcMovieDao implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    private static Movie mapToMovie (SqlRowSet result) throws NullPointerException {
        Movie movie = new Movie();
        movie.setId(result.getInt("movie_id"));
        movie.setTitle(result.getString("title"));
        movie.setOverview(result.getString("overview"));
        movie.setTagline(result.getString("tagline"));
        movie.setPosterPath(result.getString("poster_path"));
        movie.setHomePage(result.getString("home_page"));
        movie.setReleaseDate(result.getDate("release_date").toLocalDate());
        movie.setLengthMinutes(result.getInt("length_minutes"));
        movie.setDirectorId(result.getInt("director_id"));
        movie.setCollectionId(result.getInt("collection_id"));

        return movie;
    }

    public JdbcMovieDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Movie> getMovies() {
        List<Movie> movieList = new ArrayList<>();
        String sql = "Select * From movie;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()) {
            movieList.add(mapToMovie(result));
        }
        return movieList;
    }

    @Override
    public Movie getMovieById(int id) {
        Movie movie = new Movie();
        String sql = "Select * From movie WHERE movie_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if (result.next()) {
            movie = (mapToMovie(result));
        }else {
            return null;
        }
        return movie;
    }

    @Override
    public List<Movie> getMoviesByTitle(String title, boolean useWildCard) {
        List<Movie> movieTitleList = new ArrayList<>();
        String sql = "Select * From movie WHERE title ILIKE ?;";
        if (useWildCard) {
            title = "%" + title + "%";
        }
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,title);
        while (result.next()) {
            Movie movie = (mapToMovie(result));
            movieTitleList.add(movie);
        }
        return movieTitleList;
    }

    @Override
    public List<Movie> getMoviesByDirectorNameBetweenYears(String directorName, int startYear,
                                                           int endYear, boolean useWildCard) {
        List<Movie> directorList = new ArrayList<>();
        LocalDate startDate = LocalDate.of(startYear, 1, 1);
        LocalDate endDate = LocalDate.of(endYear,12,31);
        String sql = "Select * From movie WHERE director_id IN (SELECT person_id FROM person WHERE person_name ILIKE ?) AND release_date BETWEEN ? AND ?;";
        if (useWildCard) {
            directorName = "%" + directorName + "%";
        }
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, directorName, startDate, endDate);
        while (result.next()) {
            directorList.add(mapToMovie(result));
        }
        return directorList;
    }
}
