package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Review;

import java.util.List;

public interface ReviewDao {

    // Create
    Review createReview(Review review);
    // Read
    List<Review> getReviewByHotelId(int hotelId);
    List<Review> getReviews();
    // Update
    Review updateReview(Review review);
    // Delete
    void deleteReview(int hotelId, String name);

}
