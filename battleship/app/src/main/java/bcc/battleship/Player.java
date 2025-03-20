package bcc.battleship;
import bcc.battleship.Constants;

public class Player {  
    private static final int NUM_SHIPS = 5;

    private Grid myGrid;
    private Grid opponentGrid;
    private Ship[] ships;

  
    // Constructor: Initialize the grids and the ships.
    public Player() {
        myGrid = new Grid();
        opponentGrid = new Grid();
        ships = new Ship[NUM_SHIPS]; 

        ships[0] = new Ship(5); // Carrier
        ships[1] = new Ship(4); // Battleship
        ships[2] = new Ship(3); // Cruiser
        ships[3] = new Ship(3); // Submarine
        ships[4] = new Ship(2);
    }
    
    /**
     * This method is used for testing to set a ship's location.
     * It sets the ship's row, column, and direction, then adds it to the player's grid.
     *
     */
    
    public boolean chooseShipLocation(int index, int row, int col, int direction) {
        if (index < 0 || index >= NUM_SHIPS) return false; 
        if (!myGrid.hasShip(row, col)) { 
            ships[index].setLocation(row, col);
            ships[index].setDirection(direction);
            return myGrid.addShip(ships[index]); 
        }
        return false;
    }
   
    /**
     * Record a guess from the opponent.
     * This method checks the player's grid at (row, col). If there is a ship,
     * it marks a hit and returns true; otherwise, it marks a miss and returns false.
     *
     */
    public boolean recordOpponentGuess(int row, int col) {
        if (index < 0 || index >= NUM_SHIPS) return false; // Invalid index
        if (!myGrid.hasShip(row, col)) { // Ensure no overlap
            ships[index].setLocation(row, col);
            ships[index].setDirection(direction);
            return myGrid.addShip(ships[index]); // Add ship to grid
        }
    }
    
    
    public Grid getMyGrid() {
        return myGrid;
    }
    
    public Grid getOpponentGrid() {
        return opponentGrid;
    }
}
