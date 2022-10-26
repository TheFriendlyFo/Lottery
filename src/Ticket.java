import java.util.ArrayList;

public class Ticket {
    private final Lottery game;
    private final ArrayList<Integer> numbers;

    Ticket(Lottery game){
        this.game = game;
        numbers = game.draw();
    }

    Ticket(Lottery game, ArrayList<Integer> numbers) {
        this.game = game;
        this.numbers = numbers;
    }

    public Lottery getGame() {return game;}
    public ArrayList<Integer> getNumbers() {return numbers;}

    public int compareTo(Ticket compareTicket) {
        if (game != compareTicket.getGame()) {return -1;}

        int matches = 0;
        ArrayList<Integer> compareNumbers = compareTicket.getNumbers();
        int regNums = numbers.size();

        for (int i = 0; i < regNums-1; i++) {
            if (Lottery.checkFor(numbers.get(i), compareNumbers)) {
                matches++;
            }
        }
        if (numbers.get(regNums) == compareNumbers.get(regNums)) {matches += 2;}

        return matches;
    }

    public String ticketStr() {
        StringBuilder numStr = new StringBuilder();
        for (Integer number : numbers) {
            numStr.append(number).append(", ");
        }
        return numStr.toString();
    }
}
