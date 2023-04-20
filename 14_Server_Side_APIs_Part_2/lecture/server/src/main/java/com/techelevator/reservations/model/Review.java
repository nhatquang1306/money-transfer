package com.techelevator.reservations.model;

public class Review {
    int hotelId;
    String name;
    String comment;
    int numberOfStars;

    public Review(int hotelId, String name, String comment, int numberOfStars) {
        this.hotelId = hotelId;
        this.name = name;
        this.comment = comment;
        this.numberOfStars = numberOfStars;
    }
    public String getKey(){
        return hotelId+name;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(int numberOfStars) {
        this.numberOfStars = numberOfStars;
    }
}
