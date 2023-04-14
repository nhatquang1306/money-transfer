package com.techelevator;

public class HotelReservation {
    private String name;
    private int numberOfNights;
    private double estimatedTotal;

    public HotelReservation(String name, int numberOfNights) {
        this.name = name;
        this.numberOfNights = numberOfNights;
        this.estimatedTotal = numberOfNights * 59.99;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public void setEstimatedTotal(double estimatedTotal) {
        this.estimatedTotal = estimatedTotal;
    }

    public double getEstimatedTotal() {
        return estimatedTotal;
    }

    public double getActualTotal(boolean requiresCleaning, boolean usedMinibar) {
        double actualTotal = estimatedTotal;

        if (usedMinibar) {
            actualTotal += 12.99;
        }

        if (requiresCleaning) {
            actualTotal += 34.99;
            if (usedMinibar) {
                actualTotal += 34.99; // double the cleaning fee if minibar was used
            }
        }

        return actualTotal;
    }

    @Override
    public String toString() {
        return "RESERVATION - " + name + " - " + estimatedTotal;
    }
}