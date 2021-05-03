package all.chess.pieces;

import all.chess.Color;
import all.chess.board.Board;
import all.chess.board.BoardUtils;
import all.chess.board.Move;
import all.chess.board.Tile;

import java.util.HashSet;

public class Knight extends Piece {
    Knight(int[] coordinate, Color team){
        super(coordinate, team);
    }
    int row = BoardUtils.getRow(coordinate);
    int col = BoardUtils.getCol(coordinate);

    /** returns HashSet of legal moves given a Board */
    @Override
    public HashSet<Move> legalMoves(Board board){
        int[][] offsets = {{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2}};
        HashSet<Move> moves = new HashSet<>();
        for (int[] o : offsets){
            int destinationRow = row + o[0];
            int destinationCol = col + o[1];
            int[] newCoordinate = {destinationRow, destinationCol};
            if (BoardUtils.isValidCoordinate(newCoordinate)){ // ensuring coord is valid
                Tile destinationTile = board.getTile(newCoordinate);
                if (destinationTile.isEmpty()){
                    Move toAdd = new Move(board,this,newCoordinate);
                } // else if
            }


        }


        return moves;

    }
}
