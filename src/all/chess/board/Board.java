package all.chess.board;

import all.chess.Color;
import all.chess.pieces.Piece;

public class Board {
    public static class BoardBuilder{
        Color nextMover;
        Piece[][] boardLayout = new Piece[8][8];
        public BoardBuilder(){}
        public BoardBuilder setPiece(Piece piece){
            int row = piece.getRow();
            int col = piece.getCol();
            boardLayout[row][col] = piece;
            return this;
        }
        public BoardBuilder setNextMover(Color team){
            nextMover = team;
            return this;
        }
        public Board build(){
            return new Board(this);
        }
    }

    private final Tile[][] board = new Tile[8][8];
    private Board(BoardBuilder builder){


    }

    public Tile getTile(int[] coordinate){
        //TODO:
        return null;
    }
}
