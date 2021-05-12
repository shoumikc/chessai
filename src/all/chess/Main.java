package all.chess;

import all.chess.board.Board;

public class Main {
    public static void main(String[] args){
        Board board = Board.createStartingBoard();
        System.out.println(board);
    }
}
