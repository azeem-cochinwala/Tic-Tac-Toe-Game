// Azeem Adil Cochinwala

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameSession {

    // Game Session Attributes
    Grid grid;
    Player player1;
    Player player2;
    Scanner scanner;
    boolean activeGame;
    int turnCount;
    char winner;

    // Constructor
    public GameSession(Scanner scanner) {
        this.scanner = scanner;

        // Create the players for the new game session
        createPlayers();
        
        // Activate the game
        this.activeGame = true;

        //Initialize first turn (Player 1)
        this.turnCount = 1;
        player1.setTurn(true);
        player2.setTurn(false);

        // Winner is not decided yet
        this.winner = '-';

        // Create a new grid for a new game session
        grid = new Grid();
    }

    // Returns true if the game is still active, that is if it has not yet been completed
    public boolean isPlaying() {
        return this.activeGame;
    }

    // End the session and announce the winning player
    public void annouceWinner() {
        // Inform users that the game session has ended
        System.out.println("");
        System.out.println("--------------------------------------------------------------");
        System.out.println("***GAME OVER!***");
        
        // Display results
        grid.displayGrid();
        System.out.println("");
        System.out.println("Game Status: " + getWinner() + " (Winner!)");
        System.out.println("");

    }

    // Create new players for a new game session
    public void createPlayers() {    
        System.out.println("Players please register! ");

        // Create Player 1
        String player1Name = "";
        while (true) {
            System.out.print("Player 1 (X) please enter your name: ");
            player1Name = scanner.nextLine();

            // Make sure Player 1 name is not empty
            if (!player1Name.isEmpty()) {
                break;  
            } else {
                System.out.println("Player 1 name cannot be empty. Please enter a valid name.");
            }
        }
        player1 = new Player(player1Name, 'X');

        // Create Player 2
        String player2Name = "";
        while (true) {
            System.out.print("Player 2 (O) please enter your name: ");
            player2Name = scanner.nextLine();

            // Make sure Player 2 name is not empty
            if (!player2Name.isEmpty()) {
                break;  
            } else {
                System.out.println("Player 2 name cannot be empty. Please enter a valid name.");
            }
        }
        player2 = new Player(player2Name, 'O');
    }

    // Execute one turn
    public void executeTurn () {
        // Determine if there can be a new turn
        if (grid.isFull() == true) {
            // If there is no winner and the game session has ended then set result game status as tie (=)
            if (getWinner() == '-') {setWinner('=');}
            this.activeGame = false;
            
            // Inform users that the game session has ended
            System.out.println("");
            System.out.println("--------------------------------------------------------------");
            System.out.println("***GAME OVER!***");
            
            // Display results
            grid.displayGrid();
            System.out.println("");
            System.out.println("Game Status: " + getWinner() + " (Tie)");
            System.out.println("");
        }
        else if (grid.isFull() == false && this.activeGame == false) {annouceWinner();}
        else {
            // Welcome users to the new turn
            System.out.println("");
            System.out.println("--------------------------------------------------------------");
            System.out.println("***TURN NUMBER " + this.turnCount + "!***");
            System.out.println("");

            //Display current board
            grid.displayGrid();
            System.out.println("");
            System.out.println("Game Status: " + getWinner() + " (No Winner)");
            System.out.println("");

            // Execute turn for Player 2
            if (player2.turn == true && player1.turn == false) {
                System.out.println(player2.name + " (Player 2) choose one of the following boxoes: ");
                grid.listEmptyBoxes();
                System.out.println("");

                // Read in coordinate from the user for their turn
                boolean validInput = false;
                while (validInput == false) {
                    try {
                        System.out.print("Enter Row: ");
                        int r = scanner.nextInt();
                        System.out.print("Enter Column: ");
                        int c = scanner.nextInt();
                        
                        // Check if the row and column are between 0 and 2
                        if (r < 0 || r > 2 || c < 0 || c > 2) {
                            System.out.println("Invalid input! Row and Column must be between 0 and 2.");
                            scanner.nextLine();
                        } else {
                            // Now check to see if the box is empty
                            if (grid.gridArray[r][c] == ' ') {
                                validInput = true;
                                scanner.nextLine();
            
                                // Implement the user's move
                                grid.makeMove('O', r, c);
                                // Determine if it was the winning move
                                checkWinner(this.player2, r, c);
                            } 
                            else {
                                System.out.println("That box is already occupied. Please choose an empty box.");
                            }
                        }
                    } 
                    catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter valid numbers.");
                        scanner.nextLine(); 
                    }
                }       
                // Switch turns   
                player1.setTurn(true);
                player2.setTurn(false);                
            }
            // Execute turn for Player 1
            else {
                System.out.println(player1.name + " (Player 1) choose one of the following boxes: ");
                grid.listEmptyBoxes();
                System.out.println("");

                // Read in coordinate from the user for their turn
                boolean validInput = false;
                while (validInput == false){
                    try {
                        System.out.print("Enter Row: ");
                        int r = scanner.nextInt();
                        System.out.print("Enter Column: ");
                        int c = scanner.nextInt();
                        
                        // Check if the row and column are between 0 and 2
                        if (r < 0 || r > 2 || c < 0 || c > 2) {
                            System.out.println("Invalid input! Row and Column must be between 0 and 2.");
                            scanner.nextLine();
                        } else {
                            // Now check to see if the box is empty
                            if (grid.gridArray[r][c] == ' ') {
                                // Proceed with the move if valid input entered by the user
                                validInput = true;
                                scanner.nextLine();
        
                                // Implement the user's move
                                grid.makeMove('X', r, c);
                                // Determine if it was the winning move
                                checkWinner(this.player1, r, c);
                            }
                            else {
                                System.out.println("That box is already occupied. Please choose an empty box.");
                            }
                        }
                    } 
                    catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter valid numbers.");
                        scanner.nextLine(); 
                    }
                } 
                // Switch turns
                player2.setTurn(true);
                player1.setTurn(false);
            } 
        }
        this.turnCount++;
    }

    public void setWinner (char symbol) {
        this.winner = symbol;
    }

    public char getWinner () {
        return this.winner;
    }

    // Determine if the player passed in as an argument has won
    public void checkWinner(Player p, int row, int col) {
        char s = p.symbol;

        // Check row, column and diagonals for winner, and if so then end session
        if (grid.checkRow(row, s) || grid.checkColumn(col, s) || grid.checkDiagonal(s)) {
            setWinner(s);
            this.activeGame = false;
            annouceWinner();
        }
    }
}
