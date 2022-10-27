import java.util.ArrayList;
import java.util.Collections;

public class Ticket {
    private final Lottery game;
    private final ArrayList<Integer> numbers;

    Ticket(Lottery game){
        this.game = game;
        numbers = game.draw();
    }

    Ticket(Lottery game, String numberStr) {
        this.game = game;
        this.numbers = new ArrayList<>();

        for (String num : numberStr.trim().split(", ")) {
            numbers.add(Integer.valueOf(num));
        }
        Collections.sort(numbers);
    }

    public Lottery getGame() {return game;}
    public ArrayList<Integer> getNumbers() {return numbers;}

    public int compareTo(Ticket compareTicket) {
        if (game != compareTicket.getGame()) {return -1;}

        int matches = 0;
        ArrayList<Integer> compareNumbers = compareTicket.getNumbers();
        int regNums = numbers.size() - 1;

        for (int i = 0; i < regNums-1; i++) {
            if (Lottery.checkFor(numbers.get(i), compareNumbers)) {
                matches++;
            }
        }
        if (numbers.get(regNums).equals(compareNumbers.get(regNums))) {matches += 2;}

        return matches;
    }

    public String ticketStr() {
        StringBuilder numStr = new StringBuilder();
        for (Integer number : numbers) {
            numStr.append(number < 10 ? "0" : "").append(number).append(", ");
        }
        return numStr.toString();
    }
}
