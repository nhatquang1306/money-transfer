package com.techelevator.dao;

import com.techelevator.model.Reservation;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcReservationDao implements ReservationDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcReservationDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int createReservation(int siteId, String name, LocalDate fromDate, LocalDate toDate) {
        Reservation createReservation = null;
        String sql = "INSERT INTO reservation (site_id, name, from_date, to_date, create_date) " +
                "VALUES (?, ?, ?, ?, '2023-04-18') RETURNING reservation_id;";
        int siteId2 = 0;
        try {
            siteId2 = jdbcTemplate.queryForObject(sql, int.class, siteId, name, fromDate, toDate);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return siteId2;
    }
    public List<Reservation> upcomingReservationsByParkId(int parkId) {
        List<Reservation> returnList = new ArrayList<>();
        String sql = "SELECT reservation_id, reservation.site_id, reservation.name, from_date, to_date, create_date, " +
                "park.park_id, campground.campground_id " +
                "FROM reservation " +
                "JOIN site ON site.site_id = reservation.site_id " +
                "JOIN campground ON campground.campground_id = site.campground_id " +
                "JOIN park ON campground.park_id = park.park_id " +
                "WHERE park.park_id = ? AND reservation.from_date BETWEEN ? AND ?;";

try{
    SqlRowSet allRows = jdbcTemplate.queryForRowSet(sql, parkId, LocalDate.now().plusDays(1), LocalDate.now().plusDays(30));
        while(allRows.next()){
            returnList.add(mapRowToReservation(allRows));
        }
}
        catch (DataAccessException e){
            e.printStackTrace();
        }

        return returnList;
    }

    private Reservation mapRowToReservation(SqlRowSet results) {
        Reservation r = new Reservation();
        r.setReservationId(results.getInt("reservation_id"));
        r.setSiteId(results.getInt("site_id"));
        r.setName(results.getString("name"));
        r.setFromDate(results.getDate("from_date").toLocalDate());
        r.setToDate(results.getDate("to_date").toLocalDate());
        r.setCreateDate(results.getDate("create_date").toLocalDate());
        return r;
    }


}
