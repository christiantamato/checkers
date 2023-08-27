public class Tests {
    public static void main(String[] args) {
        Bitboard myBoard = new Bitboard();
        System.out.println(myBoard);

        Tile testTile = myBoard.getTile(1, 0);
        System.out.println(testTile);

        Player testPlayer = new Player("black", myBoard.getBlackStones());
        System.out.println(testPlayer);
    }
}
