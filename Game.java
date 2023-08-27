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
                System.out.println("Input the tile of the piece you would like to move");
                String tileName = input.nextLine();
                System.out.println("Input the direction you would like to move in (left or right)");
                String direction = input.nextLine();
                this.playerWhite.moveStone(tileName, direction);
            }
            else {
                System.out.println("Blacks turn");
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
}
