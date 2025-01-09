import java.util.Scanner;

public class Menu {
    private final Scanner sc = new Scanner(System.in);

    public void run() {
        String choice;
        do {
            printMenu();
            choice = getChoice();

            switch (choice) {
                case "1":
                    Avatar.printMarvin();
                    break;
                case "2":
                    Today.print();
                    break;
                case "3A":
                    RockScissorPaper game = new RockScissorPaper();
                    game.play();
                    break;
                case "3B":
                    Dice die = new Dice(6);
                    DiceGame21 game2 = new DiceGame21(die);
                    game2.play();
                    break;
                case "m":
                    printMenu();
                    break;
                case "q":
                case "Q":
                    System.out.println("Quitting..");
                    break;
                default:
                    System.err.println("Bad menu choice, use 'm' to get the menu.");
            }
        } while (!(choice.equalsIgnoreCase("q")));
    }

    public void printMenu() {
        String menuText = """
             -----------------
            | 1) Print my avatar
            | 2) Print today date/time
            | 3A) Rock Paper Scissors
            | 3B) 21 Dice Game
            | m) Print menu
            | qQ) Quit
             -----------------""";
        System.out.println(menuText);
    }

    public String getChoice() {
        System.out.print("Enter your choice : ");
        return sc.next();
    }
}
