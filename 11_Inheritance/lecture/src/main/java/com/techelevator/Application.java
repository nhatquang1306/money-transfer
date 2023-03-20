package com.techelevator;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids
        for(Bid bid: generalAuction.getAllBids()){
            System.out.println("[Name: " + bid.getBidder() + " Bid:" + bid.getBidAmount() + "] Is winning bid: "); // generalAuction.getWinningBid().equals(bid)
        }
        /**
         * Buyout Auction
         *
         *
         */

        System.out.println("-----------------------");

        BuyoutAuction buyoutAuction = new BuyoutAuction("Hour Glass Dog", 55);

        buyoutAuction.placeBid(new Bid("Carlos", 20));
        buyoutAuction.placeBid(new Bid("Alyssa", 30));
        buyoutAuction.placeBid(new Bid("Kyle", 26));
        buyoutAuction.placeBid(new Bid("Emily", 56));
        buyoutAuction.placeBid(new Bid("John", 62));

        for(Bid bid: buyoutAuction.getAllBids()){
            System.out.println("[Name: " + bid.getBidder() + " Bid:" + bid.getBidAmount() + "] Is winning bid: " + buyoutAuction.getWinningBid()); // generalAuction.getWinningBid().equals(bid)

    }


} }
