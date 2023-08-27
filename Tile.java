public class Tile {
    //the properties of the tile

    //where is the tile on the board?
    private int row;
    private int col;

    //what color is the tile? 
    private String color;
    //what is the name of the tile?
    private String name;

    //char representation of the status of the tile (Black: B, White: W, Empty: -)
    private char tileState;

    //is the tile empty or not? 
    private boolean tileEmpty;


    //constructor that will set all the values of the tile
    public Tile(int row, int col, String color, String name, char tileState, boolean tileEmpty) {
        this.row = row;
        this.col = col;
        this.color = color;
        this.name = name;
        this.tileState = tileState;
        this.tileEmpty = tileEmpty;
    }

    //the tile accessor methods

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public String getColor() {
        return this.color;
    }

    public String getName() {
        return this.name;
    }

    public char getState() {
        return this.tileState;
    }

    public boolean isTileEmpty() {
        return this.tileEmpty;
    }

    //the tile mutator methods

    public void setState(char newState) {
        this.tileState = newState;
    }

    public void setTileEmpty(boolean b) {
        this.tileEmpty = b;
    }

    //toString
    public String toString() {
        return "Tile: " + this.name + "\n" + this.tileState + "\n" + "(" + this.row + "," + this.col + ")" + "\n" + this.color + "\n" + "empty: " + this.tileEmpty + "\n";
    }
}

