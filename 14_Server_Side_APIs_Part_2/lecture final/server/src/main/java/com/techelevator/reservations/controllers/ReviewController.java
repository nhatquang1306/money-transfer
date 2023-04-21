package com.techelevator.reservations.controllers;


import com.techelevator.reservations.dao.MemoryReviewDao;
import com.techelevator.reservations.dao.ReviewDao;
import com.techelevator.reservations.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ReviewController {
    ReviewDao reviewDao;

    public ReviewController(){
        reviewDao = new MemoryReviewDao();
    }

    // create a review
    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public Review createReview(@RequestBody Review review){
        return reviewDao.createReview(review);
    }


    // get by hotel id
    @RequestMapping(path= "reviews/{id}", method = RequestMethod.GET)
    public List<Review> getByHotelId(@PathVariable int id) {
        List<Review> reviews = reviewDao.getReviewByHotelId(id);
        return reviews;
    }


    // get all reviews
    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    public List<Review> listReviews() {
        return reviewDao.getReviews();
    }
    // update a review
    @RequestMapping(path = "/reviews", method = RequestMethod.PUT)
    public Review update(@RequestBody Review review) {
        Review updatedReview = reviewDao.updateReview(review);
        if(updatedReview == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found");
        }
        else {
            return updatedReview;
        }
    }

    // delete a review
    @RequestMapping(path = "/reviews", method = RequestMethod.DELETE)
    public void deleteReview(@RequestParam int hotelId, @RequestParam String name) {
        reviewDao.deleteReview(hotelId,name);
    }
}
