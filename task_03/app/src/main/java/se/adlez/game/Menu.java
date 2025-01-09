package se.adlez.game;


import java.util.Scanner;


public class Menu {
    private final Scanner sc = new Scanner(System.in);
    Forest forest = null;


    public void run() {
        String choice;
        do {
            printMenu();
            choice = getChoice();

            switch (choice) {
                case "1": //Create an empty forest
                createForest();
                break;

                case "2": //Print the forest
                if(!forestIsNull()){
                    System.out.println(forest.getGamePlan());
                }
                break;

                case "3": //Add items (tree, rock) to the forest
                if(!forestIsNull()){
                    addFirTreeOrRock();
                }
                break;

                case "4": //List all items in the forest
                if(!forestIsNull()){
                    System.out.println(forest.listItems());
                }
                break;

                case "5": //Add 5 trees and 5 stones to the forest
                if(!forestIsNull()){
                    addFiveTreeAndRocks();
                }
                break;

                case "6": //Add player, hunter and the home
                if(!forestIsNull()){
                    addPlayerHunterCastle();
                }
                break;

                case "7": // Play game
                if(!forestIsNull()){
                    playGame();
                }
                break;

                case "8": // Save game to file.ser
                if(!forestIsNull()){
                    ForestToFile.save(forest, "forest.ser"); 
                }
                break;

                case "9": // Load game from file.ser
                if(!forestIsNull()){
                    forest = ForestToFile.load("forest.ser"); 
                    if (forest != null) {
                        System.out.println(forest.getGamePlan());
                    }
                }
                break;

                case "p": // Print game as JSON
                if(!forestIsNull()){
                    ForestToJson.printForestAsJson(forest); 
                }
                break;

                case "s": // Save game as JSON
                if(!forestIsNull()){
                    ForestToJson.saveForestAsJson(forest, "forest.json"); 
                }
                break;
                
                case "m":
                    printMenu();
                    break;
                case "q":
                case "Q":
                    System.out.println("Quitting..");
                    sc.close();
                    break;
                default:
                    System.err.println("Bad menu choice, use 'm' to get the menu.");
            }
        } while (!(choice.equalsIgnoreCase("q")));
    }

    private void createForest(){
        forest = new Forest();
        System.out.println("Forest created.");
    }

    private boolean forestIsNull(){
        if (forest == null) {
            System.out.println("Create a forest first.");
            return true;
        }else{
            return false;
        }
    }

    private void addFirTreeOrRock(){
        System.out.print("Add FirTree 🌲 (1) or Rock 🪨 (2): ");
        int itemChoice = sc.nextInt();
        System.out.print("Set position x y (separate by space): ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        Item item = (itemChoice == 1) ? new FirTree() : new Rock();
        forest.addItem(item, new Position(x, y));
        System.out.println("Added item to the forest: " + item + " (" + x + ", " + y + ")");
    }

    private void addFiveTreeAndRocks(){
        for (int i = 0; i < 5; i++) {
            forest.tryAddItem(new FirTree(), new Position((int) (Math.random() * 10) + 1, (int) (Math.random() * 10) + 1));
            forest.tryAddItem(new Rock(), new Position((int) (Math.random() * 10) + 1, (int) (Math.random() * 10) + 1));
        }
        System.out.println("5 trees and 5 rocks added.");
    }

    private void addPlayerHunterCastle(){
        forest.addPlayerItem(new Robot(new Position(1, 1)));
        forest.addHunterItem(new Wolf(new Position(8, 5)));
        forest.addHomeItem(new Castle(new Position(10, 10)));
        System.out.println("Added robot, wolf, and castle.");
    }


    private void playGame(){
        // Start the game loop
        String gameChoice;
        do {
        // Show the current game plan and status
        System.out.println(forest.getGamePlan());
        System.out.println(forest.getStatus());

        // If game over, print a final message and break the loop
        if (forest.isGameOver()) {
            
            break;
        }

        // Ask the user for input
        System.out.println("Move player left=a, right=d, up=w, down=s, quit=q.");
        System.out.print("Enter your choice: ");
        gameChoice = sc.nextLine();

        // Process the move choice
        switch (gameChoice) {
            case "a": forest.movePlayer(new Position(-1, 0)); break;
            case "d": forest.movePlayer(new Position(1, 0)); break;
            case "w": forest.movePlayer(new Position(0, -1)); break;
            case "s": forest.movePlayer(new Position(0, 1)); break;
            case "q": 
                System.out.println("Bye bye!"); 
                break;
            default: 
                System.out.println("Invalid choice, try again.");
        }
        } while (!"q".equalsIgnoreCase(gameChoice)); 
        
    }

   
    private void printMenu() {
        String menuText = """
            -----------------
            | 1) Create an empty forest
            | 2) Print the forest
            | 3) Add items (tree, rock) to the forest
            | 4) List all items in the forest
            | 5) Add 5 trees and 5 stones to the forest
            | 6) Add player, hunter and the home
            | 7) Play game
            | 8) Save game to file
            | 9) Load game from file
            | p) Print game as JSON
            | s) save game as JSON
            | m) Print menu
            | qQ) Quit
            -----------------
                """;
        System.out.println(menuText);
    }


    private String getChoice() {
        System.out.print("Enter your choice : ");
        return sc.next();
    }
}
