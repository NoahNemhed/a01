import java.util.Scanner;

public class DiceGame21 {

    int computerScore;
    int playerScore;
    Dice die;

    public DiceGame21(Dice die) {
        this.computerScore = 0;
        this.playerScore = 0;
        this.die = die;
    }


    public void play(){
        Scanner sc = new Scanner(System.in);
        System.out.println(
            """
            \n
            Welcome to a game of rock 21 dice
            You will play against Marvin.
            You roll a dice as many times as you want.
            You want to get as close as possible to 21.
            When you stop, Marvin will roll the dice 5 times.
            The one closest to 21 wins.
            Enter "q" to quit the game round and return to the menu.
            """
        );

        boolean gameOn = true;

        while(gameOn){
            System.out.println("Your current score is " + playerScore + " Do you want to roll? (y/n) or (q) for quit");
            String playerChoice = sc.next();

            switch (playerChoice.toLowerCase()) {
                case "y":
                    die.roll();
                    playerScore += die.getLastRoll();
                    System.out.println("You rolled " + die.toString() + ": " + die.getLastRoll());
                    System.out.println("Your current score: " + playerScore);

                    
                    if (playerScore == 21) {
                        System.out.println("You have rolled 21! You win!");
                        gameOn = false;
                    } else if (playerScore > 21) {
                        System.out.println("You have exceeded 21! Marvin wins!");
                        gameOn = false;
                    }
                    break;


                    case "n":
                    System.out.println("\n");
                    System.out.println("Player wants to stop at score: " + playerScore);
                    System.out.println("Now it's Marvin's turn.\n");
                
                    
                    int marvinTotalRoll = 0;
                
                    
                    for (int i = 1; i <= 5; i++) {
                        die.roll();
                        marvinTotalRoll += die.getLastRoll();
                        System.out.println("Marvin's roll " + i + ": " + die.toString() + " | Roll result: " + die.getLastRoll() + " | Marvin's current score: " + marvinTotalRoll);
                    }
                    computerScore = marvinTotalRoll;
                
                    
                    System.out.println("\nFinal Scores:");
                    System.out.println("Player's score: " + playerScore);
                    System.out.println("Marvin's score: " + computerScore);
                
                    
                    if (playerScore > 21) {
                        System.out.println("Player exceeded 21, Marvin wins!");
                    } else if (computerScore > 21) {
                        System.out.println("Marvin exceeded 21, Player wins!");
                    } else if (playerScore == computerScore) {
                        System.out.println("It's a tie! Marvin wins if scores are equal.");
                    } else if (playerScore > computerScore) {
                        System.out.println("Player wins!");
                    } else {
                        System.out.println("Marvin wins!");
                    }
                
                    
                    gameOn = false;
                    break;
                
                case "q":
                    System.out.println("You have quit the game.");
                    gameOn = false;
                    break;

                default:
                    break;
            }

        }

    }
    
}
