import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public ArrayList<Integer> getTicket(Lottery game) {}
    public static void main(String[] args) {
        Lottery powerBall = new Lottery("PowerBall", 5, 69, 26);
        ArrayList<Ticket> tickets = new ArrayList<>();
        Ticket winner = new Ticket(powerBall);

        Scanner scan = new Scanner(System.in);

        Ticket notQP = new Ticket(powerBall, scan.nextLine());
        System.out.println(winner.ticketStr());
        System.out.println(notQP.ticketStr());
        System.out.println(notQP.compareTo(winner));
    }
}
