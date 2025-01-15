// Azeem Adil Cochinwala

public class Player {

    // Attributes
    String name;
    char symbol;
    boolean turn;


    // Constructor
    public Player (String n, char s) {
        name = n;
        symbol = s;
    }

    // Retrieve the name of the player
    public String getName () {
        return this.name;
    }

    // Retrieve the symbol of the player ('X' or 'O')
    public char getSymbol () {
        return this.symbol;
    }

    // Set to true means the player is up next turn
    public void setTurn (boolean t) {
        this.turn = t;
    }

    // Retrieve turn boolean for the player
    public boolean getTurn () {
        return this.turn;
    }
}