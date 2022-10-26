public class Main {
    public static void main(String[] args) {
        Lottery powerBall = new Lottery("PowerBall", 5, 69, 26);
        Ticket winner = new Ticket(powerBall);
        Ticket luckyTicket = new Ticket(powerBall);

        System.out.println(winner.ticketStr());
        System.out.println(luckyTicket.ticketStr());

        System.out.println(luckyTicket.compareTo(winner));
    }
}
