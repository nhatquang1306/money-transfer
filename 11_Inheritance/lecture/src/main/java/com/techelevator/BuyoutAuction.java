package com.techelevator;

public class BuyoutAuction extends Auction{

    private int buyoutPrice;
    private boolean auctionClosed = false;

    public BuyoutAuction(String itemForSale, int buyoutPrice) {
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;

        if (auctionClosed) {
            return isCurrentWinningBid;
        }
        if(getHighBid().getBidAmount() < buyoutPrice) {
            if (offeredBid.getBidAmount() >= buyoutPrice) {
                offeredBid = new Bid(offeredBid.getBidder(), buyoutPrice);
                auctionClosed=true;
                return super.placeBid(offeredBid);
            }
            isCurrentWinningBid = super.placeBid(offeredBid);
        }

        return isCurrentWinningBid;
    }

}
