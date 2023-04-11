package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int getParkCount() {
        int parkCount=0;
        //1. setup sql statement to get the data that I want this method to return
        String sql = "SELECT COUNT(*) AS count FROM park;";
        //2. use the jdbcTemplate.queryForRowSet() to get the result set
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        //3. use result.next() to get the next value from result set
        if (result.next()) {
            parkCount= result.getInt("count");
        }

        return parkCount;
    }
    
    @Override
    public LocalDate getOldestParkDate() {
        LocalDate dateEstablished = null;
        String sql = "SELECT MIN(date_established) AS date_established FROM park;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        if (result.next()){
            try {
                dateEstablished = result.getDate("date_established").toLocalDate();
            }
            catch(NullPointerException e) {
                System.out.println("Null pointer in get oldest park date.");
            }

        }
        return dateEstablished;
    }
    
    @Override
    public double getAvgParkArea() {
        double avgArea = 0.0;
        String sql = "SELECT ROUND(AVG(area),2) AS avg_area from park;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        if(result.next()) {
            avgArea = result.getDouble("avg_area");
        }

        return avgArea;
    }
    
    @Override
    public List<String> getParkNames() {
        List<String> parkNames = new ArrayList<>();
        String sql = "SELECT park_name From park ORDER BY park_name ASC;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()) {
            parkNames.add(result.getString("park_name"));
        }

        return parkNames;
    }
    
    @Override
    public Park getRandomPark() {
        Park park = null;
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                "FROM park " +
                "ORDER BY RANDOM() " +
                "LIMIT 1;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        if(result.next()) {
            park = mapRowToPark(result);
        }
        return park;
    }

    @Override
    public List<Park> getParksWithCamping() {

        return new ArrayList<>();
    }

    @Override
    public Park getParkById(int parkId) {
        Park park = null;
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                "FROM park " +
                "WHERE park_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, parkId);
        if(result.next()) {
            park = mapRowToPark(result);
        }
        return park;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
            List<Park> park = new ArrayList<>();
            String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                    "FROM park join park_state using(park_id)" +
                    "WHERE state_abbreviation = ?;";
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);
            while(result.next()) {
                park.add(mapRowToPark(result));
            }
            return park;

    }

    private Park mapRowToPark(SqlRowSet rowSet) {
        Park park = new Park();
        park.setParkId(rowSet.getInt("park_id"));
        park.setParkName(rowSet.getString("park_name"));
        park.setDateEstablished(rowSet.getDate("date_established").toLocalDate());
        park.setArea(rowSet.getDouble("area"));
        park.setHasCamping(rowSet.getBoolean("has_camping"));

        return park;
    }
}
