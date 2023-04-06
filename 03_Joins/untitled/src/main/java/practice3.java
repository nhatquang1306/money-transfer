public class practice3 {
    int lotteryTicketWinner = 20;
    int ticketWinner2 = 10;

    public int GreenTicket(int a, int b, int c) {
        if (a == b && b == c) {
            return lotteryTicketWinner;
        }
        if (a == b || b == c || a == c) {
            return ticketWinner2;
        }
        return 0;
    }
}


