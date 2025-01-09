package se.adlez.game;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Forest implements Serializable{
    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    private Map<Position, Item> items = new HashMap<>();
    private AbstractMoveableItem player, hunter, home;
    private StringBuilder status = new StringBuilder();
    private boolean gameOver = false;
    private transient Random random = new Random(); // transient so we dont save random

    
    public Forest() {
        init();
    }

    // Reset the forest to an empty state
    public void init() {
        items.clear();
        player = null;
        hunter = null;
        home = null;
        gameOver = false;
        status.setLength(0);
    }

    // Add items to the forest
    public void addItem(Item item, Position position) {
        items.put(position, item);
    }

    public boolean tryAddItem(Item item, Position position) {
        if (items.containsKey(position)) return false;
        items.put(position, item);
        return true;
    }

    // Add moveable items
    public void addPlayerItem(AbstractMoveableItem player) {
        this.player = player;
    }

    public void addHunterItem(AbstractMoveableItem hunter) {
        this.hunter = hunter;
    }

    public void addHomeItem(AbstractMoveableItem home) {
        this.home = home;
    }

    // Return string representation of the forest
    public String getGamePlan() {
        StringBuilder sb = new StringBuilder();
        for (int y = 1; y <= HEIGHT; y++) {
            for (int x = 1; x <= WIDTH; x++) {
                Position pos = new Position(x, y);
                if (player != null && player.getPosition().equals(pos)) {
                    sb.append("🤖");
                } else if (hunter != null && hunter.getPosition().equals(pos)) {
                    sb.append("🐺");
                } else if (home != null && home.getPosition().equals(pos)) {
                    sb.append("🏛️");
                } else if (items.containsKey(pos)) {
                    sb.append(items.get(pos).getGraphic());
                } else {
                    sb.append("🟩");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // List all items in the forest
    public String listItems() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Position, Item> entry : items.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

    // Move the player
    public void movePlayer(Position relative) {
        // If gameover dont procced
        if (gameOver) return;
    
        // Reset status for each turn
        status.setLength(0);
    
        // Get the current player position
        Position playerPos = player.getPosition();
    
        // Prepare the new position for the player
        Position newPos = new Position(playerPos);
        newPos.move(relative);
    
        // Check if the new position is within bounds
        if (newPos.getX() < 1 || newPos.getX() > WIDTH || newPos.getY() < 1 || newPos.getY() > HEIGHT) {
            status.append("Player could not move! Out of bounds.\n");
            return;
        }
    
        // Check if the new position is free (not occupied by any other item)
        if (!items.containsKey(newPos)) {
            // Remove the player from its current position in the map
            items.remove(playerPos);
            
            // Update the player position
            playerPos.move(relative);  
    
            // Place the player in the new position
            items.put(playerPos, player);
            status.append("Player moved successfully!\n");
        } else {
            status.append("Player could not move! Position occupied.\n");
            return;
        }
    
        // Check for collision with the hunter or if the player has reached the castle
        if (checkHunterCollisionOrWin()) {
            gameOver = true; // End the game when the hunter catches the player or player reaches castle
            return;
        }
    
        // Move the hunter
        moveHunter();
    }
    

    
    
    private void moveHunter() {
        Position hunterPos = hunter.getPosition(); // Get current position of the hunter
    
        // Choose a random direction for the hunter
        int direction = random.nextInt(4); // Random number between 0 and 3
    
        // Move the hunter in a random direction
        Position newHunterPos = new Position(hunterPos); // Create a new position for the hunter
        switch (direction) {
            case 0: 
                newHunterPos.move(new Position(1, 0)); // Move right
                break;
            case 1: 
                newHunterPos.move(new Position(0, 1)); // Move down
                break;
            case 2: 
                newHunterPos.move(new Position(-1, 0)); // Move left
                break;
            case 3: 
                newHunterPos.move(new Position(0, -1)); // Move up
                break;
        }
    
        // Check if the new position is within bounds
        if (newHunterPos.getX() < 1 || newHunterPos.getX() > WIDTH || newHunterPos.getY() < 1 || newHunterPos.getY() > HEIGHT) {
            status.append("Hunter is out of bounds and cannot move!\n");
            return;  // Do not update position if it's out of bounds
        }
    
        // Remove the old hunter position from the items map before moving
        items.remove(hunter.getPosition());
    
        // Update the hunter's position 
        hunterPos.setX(newHunterPos.getX());
        hunterPos.setY(newHunterPos.getY());
    
        // Validate the hunter's new position
        if (!items.containsKey(newHunterPos)) {
            // If the new position is valid (not occupied by an obstacle), update the hunter's position
            items.put(newHunterPos, hunter); // Add the hunter to the new position in the map
            status.append("Hunter is coming closer...\n");
        } else {
            // If the new position is occupied, the hunter doesn't move
            status.append("Hunter is lurking and not moving...\n");
        }
    
        // After moving the hunter, check for collisions or win
        if (checkHunterCollisionOrWin()) {
            gameOver = true; // End the game if the hunter catches the player or player wins
        }
    }
    
    
    

// Checks if hunter catches player
private boolean checkHunterCollisionOrWin() {
    // Check if the hunter caught the player
    if (hunter.getPosition().equals(player.getPosition()) || player.getPosition().equals(hunter.getPosition())) {
        status.append("Hunter caught the player, argh!\n");
        status.append("Game is over!\n");
        return true; // Hunter caught the player
    }

    // Check if the player has reached the home
    if (player.getPosition().equals(home.getPosition())) {
        status.append("Player reached home!\n");
        status.append("Game is over!\n");
        return true; // Player reached home
    }
    
    return false; // No collision or victory
}


    // Check if the game is over
    public boolean isGameOver() {
        return gameOver;
    }

    // Get the current game status
    public String getStatus() {
        return status.toString();
    }
}


