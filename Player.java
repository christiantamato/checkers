import java.util.ArrayList;

public class Player {
    //properties of the player

    //all of the players pieces
    private ArrayList<Stone> stones;

    //how many pieces
    private int numPieces;

    //what color is the player
    private String color;

    //constructor that gives the pieces to the player
    public Player(String color, ArrayList<Stone> stones) {
        //set the color
        this.color = color;
        //give the player its stones
        this.stones = stones;
        //set to 12
        this.numPieces = 12;
    }

    //move method. Rules: stones only move diagonally on dark squares. If able to capture, the player must capture and continue capturing if possible. player cannot go backwards unless reached end of board (king).

    //checkers only move diagonally. Also make sure we are moving in the correct direction based on tile color
    public void moveStone(String tileName, String direction) {
        //go through each of the players tiles, check if any of the stones are on that tile so we know that is the one that is going to move
        for (Stone stone : this.stones) {
            //check the name
            if(stone.getTile().getName().equals(tileName)) {
                //remember the tile before movement
                Tile currentTile = stone.getTile();

                //move selected stone
                
                //color of stone
                if(this.color.equals("black")) {
                    //direction
                    if(direction.equals("right")) {
                        //moving diagonally downwards to the right
                        int newRow = stone.getTile().getRow() + 1;
                        int newCol = stone.getTile().getCol() + 1;
                        //check for availability
                        if(stone.getBoard().getTile(newRow, newCol).getState() == '-') {
                            //then allow movement
                            stone.setTile(stone.getBoard().getTile(newRow, newCol));
                            //set the stuff on the new tile
                            stone.getTile().setState('B');
                            stone.getTile().setTileEmpty(false);

                            //reset the tile that we were previously just on
                            currentTile.setState('-');
                            currentTile.setTileEmpty(true);
                        } 
                        else {
                            //just print out error msg
                            System.out.println("invalid move");
                        }                   
                    }
                    else if(direction.equals("left")) {
                         //moving diagonally downwards to the left
                         int newRow = stone.getTile().getRow() + 1;
                         int newCol = stone.getTile().getCol() - 1;

                         if(stone.getBoard().getTile(newRow, newCol).getState() == '-') {
                            stone.setTile(stone.getBoard().getTile(newRow, newCol));
                            stone.getTile().setState('B');
                            stone.getTile().setTileEmpty(false);

                            currentTile.setState('-');
                            currentTile.setTileEmpty(true);
                         }
                         else {
                            System.out.println("invalid move");
                         }
                    }
                }
                else if(this.color.equals("white")) {
                    //direction
                    if(direction.equals("right")) {
                        //moving diagonally upwards to the right
                        int newRow = stone.getTile().getRow() - 1;
                        int newCol = stone.getTile().getCol() + 1;

                        if(stone.getBoard().getTile(newRow, newCol).getState() == '-') {
                            stone.setTile(stone.getBoard().getTile(newRow, newCol));
                            stone.getTile().setState('W');
                            stone.getTile().setTileEmpty(false);

                            currentTile.setState('-');
                            currentTile.setTileEmpty(true);
                        }
                        else {
                            System.out.println("invalid move");
                        }
                    }
                    else if(direction.equals("left")) {
                         //moving diagonally to the left
                         int newRow = stone.getTile().getRow() - 1;
                         int newCol = stone.getTile().getCol() - 1;

                         if(stone.getBoard().getTile(newRow, newCol).getState() == '-') {
                            stone.setTile(stone.getBoard().getTile(newRow, newCol));
                            stone.getTile().setState('W');
                            stone.getTile().setTileEmpty(false);

                            currentTile.setState('-');
                            currentTile.setTileEmpty(true); 
                        }
                        else {
                            System.out.println("invalid move");
                        }
                    }
                }
                //also break
                break;
            }
        }
    }

    //getters
    public ArrayList<Stone> getStones() {
        return this.stones;
    }

    public String getColor() {
        return this.color;
    }

    //toString
    public String toString() {
        return "Player: " + this.color + "\n" + "Pieces: " + this.numPieces + "\n";
    }
    
}
