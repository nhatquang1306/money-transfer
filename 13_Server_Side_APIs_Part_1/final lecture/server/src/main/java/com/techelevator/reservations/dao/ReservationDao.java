package com.techelevator.reservations.dao;

import java.util.List;
import com.techelevator.reservations.model.Reservation;

public interface ReservationDao {

    List<Reservation> findAll();

    List<Reservation> findByHotel(int hotelId);

    Reservation get(int reservationId);

    /**
     * Creates a new reservation
     *
     * @param reservation the reservation to be created
     * @param hotelId hotel id of the reservation
     * @return returns the reservation that was created
     */
    Reservation create(Reservation reservation, int hotelId);

}
