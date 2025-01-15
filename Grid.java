// Azeem Adil Cochinwala

public class Grid {

    // Attributes
    char[][] gridArray;

    // Constructor 
    public Grid () {
        // Initialize the grid array
        gridArray = new char[3][3];

        // Set all boxes to be empty
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                gridArray[row][col] = ' ';
            }
        }
    }

    // Print the grid
    public void  displayGrid () {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(" " + this.gridArray[row][col]);
                if (col < 2) {System.out.print(" |");}
            }
            System.out.println();
            if (row < 2) {System.out.println("---+---+---");}
        }
    } 

    // Print the grid for the rules menu
    public void displayRulesGrid () {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(" (" + row + ", " + col + ")");
                if (col < 2) {System.out.print(" |");}
            }
            System.out.println();
            if (row < 2) {System.out.println("--------+--------+--------");}
        }
    }

    // For a new game session empty the grid
    public void resetGrid () {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                this.gridArray[row][col] = ' ';
            }
        }
    }

    // Return a list of box coordinates (x,y) that are empty
    public void listEmptyBoxes () {
        if (this.isFull() == false) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (this.gridArray[row][col] == ' ') { 
                        System.out.print("(" + row + ", " + col + ") ");
                    }
                }  
            }
        }
    }

    // Make sure each index of the array is NOT empty
    public boolean isFull () {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                // If at least one box is empty then the grid is not full
                if (this.gridArray[row][col] == ' ') {
                    return false; 
                }
            }
        }
        return true; 
    }

    // Place the player's symbol in the intended box via coordinate provided
    public void makeMove (char player, int row, int col) {
        this.gridArray[row][col] = player;
    }

     
    // Check all three rows if there is sequence of the same symbol
    public boolean checkRow (int row, char symbol) {
        for (int col = 0; col < 3; col++) {
            if (this.gridArray[row][col] != symbol) {
                // Return false when inconsistency is found
                return false;
            }
        }
        // Return true if all boxes match the symbol
        return true;
    }

    // Check all three columns if there is a sequence of the symbol
    public boolean checkColumn (int col, char symbol) {
        for (int row = 0; row < 3; row++) {
            if (this.gridArray[row][col] != symbol) {
                // Return false when inconsistency is found
                return false;
            }
        }
        // Return true if all boxes match the symbol
        return true;
    }

    // Check both diagonals if there is a sequence of the symbol
    public boolean checkDiagonal (char symbol) {
        // Variables representing the winning condition on both diagonals
        boolean diagonalLeftToRight = true;
        boolean diagonalRightToLeft = true;

        // Check the diagonal starting from the top left and ending bottom right
        for (int i = 0; i < 3; i++) {
            if (this.gridArray[i][i] != symbol) {
                // Return false when inconsistency is found
                diagonalLeftToRight = false;
                break;
            }
        }

        // Check the diagonal starting from the top right and ending bottom left
        for (int i = 0; i < 3; i++) {
            if (this.gridArray[i][2 - i] != symbol) {
                // Return false when inconsistency is found
                diagonalRightToLeft = false;
                break;
            }
        }

        // Return true if either one of the diagonals has a consistent sequence
        return diagonalLeftToRight || diagonalRightToLeft; 
    }
    
}

