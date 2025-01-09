import java.util.Random;

public class Dice {
    

    private int sides;
    private int lastRoll = 1;
    private String[] diceGraphics = {"⚀", "⚁", "⚂", "⚃", "⚄", "⚅"};


    public Dice(int sides) {
        this.sides = sides;
    }

    public int roll(){
        Random rn = new Random();
        lastRoll = rn.nextInt(sides) + 1;
        setLastRoll(lastRoll);
        return lastRoll;
    }

    

    @Override
    public String toString() {
        return diceGraphics[lastRoll - 1];
    }

    public int getLastRoll() {
        return lastRoll;
    }

    public void setLastRoll(int lastRoll) {
        this.lastRoll = lastRoll;
    }

    public String[] getDiceGraphics() {
        return diceGraphics;
    }
    
    
}
