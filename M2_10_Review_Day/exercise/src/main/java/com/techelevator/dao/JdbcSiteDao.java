package com.techelevator.dao;

import com.techelevator.model.Site;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JdbcSiteDao implements SiteDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcSiteDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Site> getSitesThatAllowRVs(int parkId) {
        List<Site> listOfSites = new ArrayList<>();
        String sql = "SELECT * FROM site WHERE max_rv_length > 0;";
        SqlRowSet allRows = jdbcTemplate.queryForRowSet(sql);

        while(allRows.next()){
            listOfSites.add(mapRowToSite(allRows));
        }
        return listOfSites;
    }
    public List<Site> getSitesByParkId(int parkId){
        List<Site> getSites = new ArrayList<>();
        String sql = "SELECT site.site_id, site.campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities FROM reservation " +
                "JOIN site ON site.site_id = reservation.site_id " +
                "JOIN campground ON campground.campground_id = site.campground_id " +
                "JOIN park ON park.park_id = campground.park_id " +
                "WHERE park.park_id = ? AND from_date>?;";
        try{
            SqlRowSet allRows = jdbcTemplate.queryForRowSet(sql, parkId, LocalDate.now());
            while(allRows.next()) {
                getSites.add(mapRowToSite(allRows));
            }
        } catch (DataAccessException e){
            e.printStackTrace();
        }
    return getSites;
    }

    private Site mapRowToSite(SqlRowSet results) {
        Site site = new Site();
        site.setSiteId(results.getInt("site_id"));
        site.setCampgroundId(results.getInt("campground_id"));
        site.setSiteNumber(results.getInt("site_number"));
        site.setMaxOccupancy(results.getInt("max_occupancy"));
        site.setAccessible(results.getBoolean("accessible"));
        site.setMaxRvLength(results.getInt("max_rv_length"));
        site.setUtilities(results.getBoolean("utilities"));
        return site;
    }
}
