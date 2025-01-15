# Tic-Tac-Toe Game

A simple and interactive console-based Tic-Tac-Toe game built in Java. 
This project allows two players to compete against each other on a 3x3 grid, following classic Tic-Tac-Toe rules. 

## Features

- **Two-player gameplay**: Players X and O take turns placing their symbols on the grid.
- **Dynamic grid display**: The game grid updates in real time after every move.
- **Rule validation**: Prevents invalid moves such as overwriting an occupied cell.
- **Win detection**: Identifies a winner based on row, column, or diagonal matches.
- **Tie detection**: Ends the game when the grid is full without a winner.
- **Replayability**: Option to start a new game after completing a session.

## Program Structure

The project consists of the following core classes:

### **1. `UserInterface`**
- Handles user interactions and game flow.
- Displays rules, takes input, and manages replay options.

### **2. `GameSession`**
- Manages the game logic and player turns.
- Determines if the game is still active with the `isPlaying()` method.
- Tracks the winner using the `getWinner()` method.

### **3. `Grid`**
- Represents the 3x3 game grid.
- Handles moves with the `makeMove()` method.
- Checks for win conditions in rows, columns, and diagonals.

### **4. `Player`**
- Represents each player with a name, symbol, and turn indicator.

## How to Run

1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/yourusername/tic-tac-toe.git
   cd tic-tac-toe
2. Compile the Java files:
   ```bash
   javac *.java
3. Run the program:
   ```bash
   java UserInterface
