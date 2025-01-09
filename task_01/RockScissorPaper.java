import java.util.Random;
import java.util.Scanner;

public class RockScissorPaper {
    Random rn = new Random();
    Scanner sc = new Scanner(System.in);
    int playerScore = 0;
    int computerScore = 0;

    public void play(){
        System.out.println(
            """
            Welcome to a game of rock ✊, scissor ✂, paper ✋!
            You will play against Marvin and we keep score.
            """
        );

        boolean gameOn = true;

        while(gameOn){
            System.out.println("Score: " + "You " + playerScore + " - " + "Marvin " + computerScore);
            System.out.println("Select rock ✊ [r], scissor ✂ [s], paper ✋ [p] or quit [q]:");
            //Ger datorn en siffra mellan 1-3, 1 är sten 2 är sax och 3 är papper
            int computerChoice = rn.nextInt(3) + 1;
            String playerChoice = sc.next();


            switch(playerChoice.toLowerCase()){
                case "r":
                    if(computerChoice == 1){
                        System.out.println("You did rock ✊ and Marvin did rock ✊. You are equal! No points!");
                        System.out.println("\n");
                        break;
                    }
                    if(computerChoice == 2){
                        System.out.println("You did rock ✊ and Marvin did scissor ✂. Player wins 1 point!");
                        System.out.println("\n");
                        playerScore++;
                        break;
                    }
                    if(computerChoice == 3){
                        System.out.println("You did rock ✊ and Marvin did paper ✋. Marvin wins 1 point!");
                        System.out.println("\n");
                        computerScore++;
                        break;
                    }

                case "s":
                    if(computerChoice == 1){
                        System.out.println("Player did scissor ✂ and Marvin did rock ✊. Marvin wins 1 point!");
                        System.out.println("\n");
                        computerScore++;
                        break;
                    }
                    if(computerChoice == 2){
                        System.out.println("Player did scissor ✂ and Marvin did scissor ✂. You are equal! No points!");
                        System.out.println("\n");
                        break;
                    }
                    if(computerChoice == 3){
                        System.out.println("Player did scissor ✂ and Marvin did paper ✋. Player wins 1 point!");
                        System.out.println("\n");
                        playerScore++;
                        break;
                    }

                case "p":
                    if(computerChoice == 1){
                        System.out.println("Player did paper ✋ and Marvin did rock ✊. Player wins 1 point!");
                        System.out.println("\n");
                        playerScore++;
                        break;
                    }
                    if(computerChoice == 2){
                        System.out.println("Player did paper ✋ and Marvin did scissor ✂. Marvin wins 1 point!");
                        System.out.println("\n");
                        computerScore++;
                        break;    
                    }
                    if(computerChoice == 3){
                        System.out.println("Player did paper ✋ and Marvin did paper ✋. You are equal! No points!");
                        System.out.println("\n");
                        break;
                    }
                
                case "q":
                    if(playerChoice.equals("q") || playerChoice.equals("Q")){
                        System.out.println("FinalScore: " + "You " + playerScore + " - " + "Marvin " + computerScore);
                        System.out.println("Quiting game.. ");
                        gameOn = false;
                    }
                
            }
            


        }
        

    }
    
}
