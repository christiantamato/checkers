public class Stone {
    //properties of the checkers piece

    //the current tile that it is on
    private Tile currentTile;
    //what color is the stone?
    private String color;
    //give it a link to the board
    private Bitboard board;

    public Stone(Tile currentTile, String color, Bitboard board) {
        //contructor, set the properties of the pawn
        this.currentTile = currentTile;
        this.color = color;
        this.board = board;
    }

    //getters

    public Tile getTile() {
        return this.currentTile;
    }

    public int getRow() {
        return this.currentTile.getRow();
    }
    public int getCol() {
        return this.currentTile.getCol();
    }

    public String getColor() {
        return this.color;
    }

    public Bitboard getBoard() {
        return this.board;
    }

    //setters

    public void setTile(Tile newTile) {
        this.currentTile = newTile;
    }

    //toString
    public String toString() {
        return "Stone Attributes: " + "\n" + "Color: " + this.color + "\n" + "Tile: " + this.currentTile.getName();
    }

    
}
