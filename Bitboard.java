import java.util.ArrayList;

public class Bitboard {
    //properties of the bitboard

    //2D array of all the tiles
    private Tile[][] board;

    //white stones and black stones
    private ArrayList<Stone> whiteStones;
    private ArrayList<Stone> blackStones;

    //bitboard constructor that will create all the tiles
    public Bitboard() {
        //initialize the 8x8 board
        this.board = new Tile[8][8];
        //initialize stones
        this.whiteStones = new ArrayList<>();
        this.blackStones = new ArrayList<>();

        //variable to switch between black and white for the tiles
        String color = "white";

        //variables for the name of the tile
        char letter = 'A';
        int number = 8;

        //put in the tiles into the board
        for (int row = 0; row < this.board.length; row++) {
            for (int col = 0; col < this.board.length; col++) {

                //make the name of the tile
                String name = letter + Integer.toString(number);
                

                //stones stuff, all stones must be on dark tiles for setup
                if((row == 0 || row == 1 || row == 2) && color.equals("black")) {
                    Tile t = new Tile(row, col, color, name , 'B' , false);
                    this.board[row][col] = t;
                    //black stones
                    Stone s = new Stone(t, color, this);
                    this.blackStones.add(s);
                }
                else if((row == 5 || row == 6 || row == 7) && color.equals("black")) {
                    Tile t = new Tile(row, col, color, name , 'W' , false);
                    this.board[row][col] = t;
                    //white stones
                    Stone s = new Stone(t, color, this);
                    this.whiteStones.add(s);
                }
                else {
                    //make the tile, and keep all of them empty to start
                    Tile t = new Tile(row, col, color, name , '-' , true);
                    //add it to the board
                    this.board[row][col] = t;
                }

                //update the variables
                if(col != 7) {
                    //don't color switch on last tile
                    color = tileColorSwitch(color);
                }
                letter++;                
            }
            //decrement the number
            number--;
            //reset the letter back to starting position
            letter = 'A';
        }
    }

    //getters

    public Tile getTile(int row, int col) {
        return this.board[row][col];
    }

    public ArrayList<Stone> getWhiteStones() {
        return this.whiteStones;
    }

    public ArrayList<Stone> getBlackStones() {
        return this.blackStones;
    }

    //setters
    public void setTileState(Tile t, char state) {
        t.setState(state);
    }

    //toString
    public String toString() {
        String theString = "";

        //do it
        for (int row = 0; row < this.board.length; row++) {
            //make a new line
            theString += "\n";
            for (int col = 0; col < this.board.length; col++) {
                //add to string
                theString += this.board[row][col].getState();
                //make a space
                theString += " ";
            }
        }
        //new line
        theString += "\n";
        return theString;
    }

    //helper method
    private String tileColorSwitch(String s) {

        if(s.equals("black")) {
            //switch to white
            s = "white";
        }
        else {
            //switch to black
            s = "black";
        }

        return s;
    }
}
