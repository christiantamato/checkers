import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    //all the game logic

    //everything needed for the game to happen
    private Bitboard board;
    private Player playerWhite;
    private Player playerBlack;


    public Game() {
        this.board = new Bitboard();
        this.playerWhite = new Player("white", this.board.getWhiteStones());
        this.playerBlack = new Player("black", this.board.getBlackStones());
    }
    
    //the game method
    public void playGame() {
        //game loop goes here!

        //start game loop
        boolean gameOver = false;
        int turnCount = 0;
        Scanner input = new Scanner(System.in);
        //if even, white goes, if odd, black goes

        while(!gameOver) {
            //update board
            System.out.println(board);
            
            //players take turns moving
            if(turnCount % 2 == 0) {
                System.out.println("Whites turn");

                //can jump?
                System.out.println(canJump(playerWhite));

                System.out.println("Input the tile of the piece you would like to move");
                String tileName = input.nextLine();
                System.out.println("Input the direction you would like to move in (left or right)");
                String direction = input.nextLine();
                this.playerWhite.moveStone(tileName, direction);
            }
            else {
                System.out.println("Blacks turn");

                //can jump?
                System.out.println(canJump(playerBlack));

                System.out.println("Input the tile of the piece you would like to move");
                String tileName = input.nextLine();
                System.out.println("Input the direction you would like to move in (left or right)");
                String direction = input.nextLine();
                this.playerBlack.moveStone(tileName, direction);
            }

            //change count
            turnCount++;
        }
        /* 
        //print board
        System.out.println(board);
        //test move black
        this.playerBlack.moveStone("F6", "left");
        //board update
        System.out.println(board);
        //test move white
        this.playerWhite.moveStone("C3", "right");
        //update board
        System.out.println(board);
        //TESTING INVALID MOVE!
        this.playerWhite.moveStone("D4", "right");
        //update board
        System.out.println(board);
        */
    }

    //jumping method has to be in this class I think, so we have access to board and other players pieces

    // method to check if player can make a jumping move
    private String canJump(Player player) {

        // the array where we will store valid tile spaces that can jump (or not)
        ArrayList<Tile> validJumpTiles = new ArrayList<>();

        // go through the players pieces
        for (Stone s : player.getStones()) {

            // get the tile
            Tile currentTile = s.getTile();

            // get tile row and col
            int currentTileRow = currentTile.getRow();
            int currentTileCol = currentTile.getCol();

            // get the tiles for the tiles diagonal to the current one, but also we have to
            // account for player color to determine which tiles we're looking at
            if (player.getColor().equals("white")) {

                // get the tiles we need to look at, but also make sure to not check for out of
                // bounds tiles. (tiles in col 0 or 1 can't go left, and tiles in col 6 or 7
                // cant go right)
                if (currentTileCol != 0 && currentTileCol != 1 && currentTileCol != 6 && currentTileCol != 7) {
                    // this means we must check both diagonal tiles, no out of bounds exceptions
                    Tile diagonalLeftTile = this.board.getTile(currentTileRow - 1, currentTileCol - 1);
                    Tile diagonalRightTile = this.board.getTile(currentTileRow - 1, currentTileCol + 1);

                    // now check tile states for left
                    if (diagonalLeftTile.getState() == 'B') {

                        // then now you gotta check if there is an empty tile in that direction
                        Tile nextTile = this.board.getTile(diagonalLeftTile.getRow() - 1, diagonalLeftTile.getCol() - 1);

                        if (nextTile.getState() == '-') {

                            // if this is true then jumping is possible
                            validJumpTiles.add(nextTile);
                        }
                    }
                    // check tiles states for right
                    if (diagonalRightTile.getState() == 'B') {

                        // then now you gotta check if there is an empty tile in that direction
                        Tile nextTile = this.board.getTile(diagonalRightTile.getRow() - 1, diagonalRightTile.getCol() + 1);

                        if (nextTile.getState() == '-') {

                            // if this is true then jumping is possible
                            validJumpTiles.add(nextTile);
                        }
                    }
                } else if (currentTileCol == 0 || currentTileCol == 1) {
                    // only check the right tiles
                    Tile diagonalRightTile = this.board.getTile(currentTileRow - 1, currentTileCol + 1);

                    // check tiles states for right
                    if (diagonalRightTile.getState() == 'B') {

                        // then now you gotta check if there is an empty tile in that direction
                        Tile nextTile = this.board.getTile(diagonalRightTile.getRow() - 1, diagonalRightTile.getCol() + 1);

                        if (nextTile.getState() == '-') {

                            // if this is true then jumping is possible
                            validJumpTiles.add(nextTile);
                        }
                    }
                } else if (currentTileCol == 6 || currentTileCol == 7) {
                    // only check left tiles
                    Tile diagonalLeftTile = this.board.getTile(currentTileRow - 1, currentTileCol - 1);

                    // now check tile states for left
                    if (diagonalLeftTile.getState() == 'B') {

                        // then now you gotta check if there is an empty tile in that direction
                        Tile nextTile = this.board.getTile(diagonalLeftTile.getRow() - 1, diagonalLeftTile.getCol() - 1);

                        if (nextTile.getState() == '-') {

                            // if this is true then jumping is possible
                            validJumpTiles.add(nextTile);
                        }
                    }
                }
            }

            if (player.getColor().equals("black")) {

                //do the diagonal checks for black, remember we are starting from the top and going down the board
                if (currentTileCol != 0 && currentTileCol != 1 && currentTileCol != 6 && currentTileCol != 7) {
                    // this means we must check both diagonal tiles, no out of bounds exceptions
                    Tile diagonalLeftTile = this.board.getTile(currentTileRow + 1, currentTileCol - 1);
                    Tile diagonalRightTile = this.board.getTile(currentTileRow + 1, currentTileCol + 1);

                    // now check tile states for left
                    if (diagonalLeftTile.getState() == 'W') {

                        // then now you gotta check if there is an empty tile in that direction
                        Tile nextTile = this.board.getTile(diagonalLeftTile.getRow() + 1, diagonalLeftTile.getCol() - 1);

                        if (nextTile.getState() == '-') {

                            // if this is true then jumping is possible
                            validJumpTiles.add(nextTile);
                        }
                    }
                    // check tiles states for right
                    if (diagonalRightTile.getState() == 'W') {

                        // then now you gotta check if there is an empty tile in that direction
                        Tile nextTile = this.board.getTile(diagonalRightTile.getRow() + 1, diagonalRightTile.getCol() + 1);

                        if (nextTile.getState() == '-') {

                            // if this is true then jumping is possible
                            validJumpTiles.add(nextTile);
                        }
                    }
                } else if (currentTileCol == 0 || currentTileCol == 1) {
                    // only check the right tiles
                    Tile diagonalRightTile = this.board.getTile(currentTileRow + 1, currentTileCol + 1);

                    // check tiles states for right
                    if (diagonalRightTile.getState() == 'W') {

                        // then now you gotta check if there is an empty tile in that direction
                        Tile nextTile = this.board.getTile(diagonalRightTile.getRow() + 1, diagonalRightTile.getCol() + 1);

                        if (nextTile.getState() == '-') {

                            // if this is true then jumping is possible
                            validJumpTiles.add(nextTile);
                        }
                    }
                } else if (currentTileCol == 6 || currentTileCol == 7) {
                    // only check left tiles
                    Tile diagonalLeftTile = this.board.getTile(currentTileRow + 1, currentTileCol - 1);

                    // now check tile states for left
                    if (diagonalLeftTile.getState() == 'W') {

                        // then now you gotta check if there is an empty tile in that direction
                        Tile nextTile = this.board.getTile(diagonalLeftTile.getRow() + 1, diagonalLeftTile.getCol() - 1);

                        if (nextTile.getState() == '-') {

                            // if this is true then jumping is possible
                            validJumpTiles.add(nextTile);
                        }
                    }
                }
            }
        }

        // figure out if we have the ability to jump
        if (validJumpTiles.size() > 0) {

            // this means we CAN jump! Now we have to let the player know which tiles are
            // able to jump. iterate the array
            String tiles = "";

            for (Tile tile : validJumpTiles) {
                tiles += tile.getName() + ", ";
            }

            // now do the return message
            return "Player can jump. Player can jump to the tile(s): " + tiles;

        } else {
            // no jumping is available
            return "Player cannot jump";
        }
    }
}
