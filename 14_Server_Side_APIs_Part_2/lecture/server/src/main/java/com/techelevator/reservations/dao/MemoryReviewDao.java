package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Review;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryReviewDao implements ReviewDao{
    private List<Review> reviews = new ArrayList<>();

    public MemoryReviewDao(){
        reviews.add(new Review(1, "Tia B.", "not bad", 3));
        reviews.add(new Review(1, "Kevin", "great", 3));
        reviews.add(new Review(2, "Nicole", "excellent", 3));

    }

    @Override
    public Review createReview(Review review) {
        reviews.add(review);
        return review;
    }

    @Override
    public List<Review> getReviewByHotelId(int hotelId) {
        List<Review> returnList = new ArrayList<>();
        for (Review review: reviews){
            if (review.getHotelId() == hotelId){
                returnList.add(review);
            }
        }
        return returnList;
    }

    @Override
    public List<Review> getReviews() {
        return reviews;
    }

    @Override
    public Review updateReview(Review review) {
        for (Review r: reviews){
            if (r.getKey().equals(review.getKey())){
                r.setComment(review.getComment());
                r.setNumberOfStars(review.getNumberOfStars());
                return r;
            }
        }
        return null;
    }

    @Override
    public void deleteReview(int hotelId, String name) {
        String deleteKey = hotelId + name;
        for (int i = 0; i < reviews.size(); i++) {
            if (reviews.get(i).getKey().equals(deleteKey)){
                reviews.remove(i);
            }

        }
    }
}
