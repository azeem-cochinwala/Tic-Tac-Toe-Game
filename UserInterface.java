// Azeem Adil Cochinwala

import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {
        // Create the scanner
        Scanner scanner = new Scanner(System.in);
        // Condition to exit the game
        boolean exitGame = false;

        do {
            // Welcome users
            System.out.println("");
            System.out.println("--------------------------------------------------------------");
            System.out.println("Welcome to Tic-Tac-Toe!");
            System.out.println("");

            // Print Game Rules
            displayRules();

            // Start a game session
            GameSession session = new GameSession(scanner);
            do {
                session.executeTurn();
            }
            while(session.isPlaying() == true);    

            // Ask users collectively if they want to play again
            String startAgain = "";
            while (true) {
                System.out.println("");
                System.out.print("Do you want to play again? (yes/no): ");
                startAgain = scanner.nextLine().toLowerCase().trim();

                // Check for valid input
                if (startAgain.equals("yes") || startAgain.equals("no")) {
                    break;
                } else {
                    System.out.println("Invalid input! Please enter yes/no.");
                }
            }


            if (startAgain.equals("no")) {
                exitGame = true;
                System.out.println("***Goodbye!***");
            }
        }
        while (exitGame == false);
    }

    public static void displayRules() {
        System.out.println("***GAME RULES!***");
        System.out.println("1.  The game is played on a 3x3 grid.");
        System.out.println("2.  Player 1 is represented as 'X', and Player 2 is represented as 'O'.");
        System.out.println("3.  Players take turns placing their symbol on the grid.");
        System.out.println("4.  A player wins if they get three of their symbols in a consecutive sequence.");
        System.out.println("5.  If all cells are filled and no player has won, the game ends in a tie (=).");
        System.out.println("6.  Player 1 (X) always goes first.");
        System.out.println("7.  Enter coordinates (row, column) to place your symbol [(0, 2) for the top-right corner].");
        System.out.println("8.  Invalid moves (e.g., placing a symbol on an already occupied cell) are not allowed.");
        System.out.println("9.  You may restart or quit the game after any round.");
        System.out.println("10. Good luck and have fun!");
        System.out.println("");
        Grid rulesGrid = new Grid();
        rulesGrid.displayRulesGrid();
        System.out.println("");
    }
}
