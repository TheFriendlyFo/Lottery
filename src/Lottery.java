import java.util.ArrayList;
import java.util.Collections;

public class Lottery {
    final private String name;
    final private int regNums;
    final private int regLower, regUpper;
    final private int powLower, powUpper;

    Lottery(String name, int regNums, int regUpper, int powUpper){
        this.name = name;
        this.regNums = regNums;
        this.regLower = 1;
        this.regUpper = regUpper;
        this.powLower = 1;
        this.powUpper = powUpper;
    }

    Lottery(String name, int regNums, int regLower, int regUpper, int powLower, int powUpper){
        this.name = name;
        this.regNums = regNums;
        this.regLower = regLower;
        this.regUpper = regUpper;
        this.powLower = powLower;
        this.powUpper = powUpper;
    }

    public static boolean checkFor(int target, ArrayList<Integer> checkList) {
        for (Integer checkInt : checkList) {
            if (checkInt == target) {return true;}
        }
        return false;
    }

    private static int rand(int lower, int upper) {
        return (int)(Math.random() * (upper - lower + 1)) + lower;
    }

    private static int randCheck(int lower, int upper, ArrayList<Integer> checkList) {
        int randInt = rand(lower, upper);
        return !checkFor(randInt, checkList) ? randInt : randCheck(lower, upper, checkList);
    }

    public String getName() {return name;}
    public int getRegNums() {return regNums;}
    public int getRegLower() {return regLower;}
    public int getPowLower() {return powLower;}
    public int getPowUpper() {return powUpper;}
    public ArrayList<Integer> draw() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i=0; i<regNums; i++) {
            numbers.add(randCheck(regLower, regUpper, numbers));
        }
        Collections.sort(numbers);
        numbers.add(rand(powLower, powUpper));
        return numbers;
    }

}
