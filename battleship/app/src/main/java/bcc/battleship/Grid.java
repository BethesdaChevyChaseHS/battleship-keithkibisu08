package bcc.battleship;

public class Grid {
    private static final int ROWS = 10;
    private static final int COLS = 10;
    private Location[][] grid;
    
    
    // Create a new Grid and initialize each Location.
    public Grid() { 

        
    }
    
    // Mark a hit in the specified location.
    public void markHit(int row, int col) {
        if (isValid(row, col)) {
            grid[row][col].markHit();
        }
    }
    
    // Mark a miss in the specified location.
    public void markMiss(int row, int col) { 
        if (isValid(row, col)) {
            grid[row][col].markMiss();
        }

    }
    
    // Set the status of the Location at (row, col).
    public void setStatus(int row, int col, int status) { 
        if (isValid(row, col)) {
            grid[row][col].setStatus(status);
        }
    }
    
    // Get the status of the Location at (row, col).
    public int getStatus(int row, int col) {
        return isValid(row, col) ? grid[row][col].getStatus() : -1;
    }
    
    // Return whether this Location has already been guessed.
    public boolean alreadyGuessed(int row, int col) {
        int status = getStatus(row, col);
        return status == Location.HIT || status == Location.MISS;
    }
    
    // Set whether there is a ship at this location.
    public void setShip(int row, int col, boolean val) { 
        if (isValid(row, col)) {
            grid[row][col].setShip(val);
        }
    }
    
    // Return whether there is a ship at this location.
    public boolean hasShip(int row, int col) {
        return isValid(row, col) && grid[row][col].hasShip();
    }
    
    // Get the Location object at this row and column.
    public Location get(int row, int col) {
        return isValid(row, col) ? grid[row][col] : null;
    }
    
    // Return the number of rows.
    public int numRows() {
        return ROWS;
    }
    
    // Return the number of columns.
    public int numCols() {
        return COLS;
    }
    

    //maybe convert to boolean?
    public boolean addShip(Ship s) {
        int row = s.getRow();
        int col = s.getCol();
        int length = s.getLength();
        int direction = s.getDirection(); 
        if (direction == Constants.HORIZONTAL) {
           
            if (col + length > COLS) return false; 
            for (int i = 0; i < length; i++) {
                if (hasShip(row, col + i)) return false; 
            }
            for (int i = 0; i < length; i++) {
                setShip(row, col + i, true);
            }
        } else if (direction == Constants.VERTICAL) {
            if (row + length > ROWS) return false; 
            for (int i = 0; i < length; i++) {
                if (hasShip(row + i, col)) return false; 
            }
            for (int i = 0; i < length; i++) {
                setShip(row + i, col, true);
            }
        } else {
            return false
    }

    public boolean allShipsSank(){
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c].hasShip() && grid[r][c].getStatus() != Location.HIT) {
                    return false; // A ship is still alive
                }
            }
        }
        return true;
    }
}
