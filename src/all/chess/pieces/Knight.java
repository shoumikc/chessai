package all.chess.pieces;

import all.chess.Team;
import all.chess.board.*;

import java.util.HashSet;

public class Knight extends Piece {
    public Knight(int[] coordinate, Team team){
        super(coordinate, team);
    }
    /** returns HashSet of legal moves given a Board */
    @Override
    public HashSet<Move> legalMoves(Board board){
        HashSet<Move> moves = new HashSet<>();
        int[][] offsets = {{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2}};
        for (int[] o : offsets){
            int destinationRow = row + o[0];
            int destinationCol = col + o[1];
            int[] newCoordinate = {destinationRow, destinationCol};
            Move toAdd = null;

            if (BoardUtils.isValidCoordinate(newCoordinate)) { // ensuring coord is valid
                Tile destinationTile = board.getTile(newCoordinate);
                if (destinationTile.isEmpty()){
                    toAdd = new Move(board, this, newCoordinate);
                } else {
                    Piece destinationPiece = destinationTile.getPiece();
                    Team destinationTeam = destinationPiece.getTeam();
                    if (destinationTeam != this.getTeam()) {
                        toAdd = new AttackMove(board, this, newCoordinate, destinationPiece);
                    }
                }
                if (toAdd != null){ // adding to hash set if valid move
                    moves.add(toAdd);
                }
            }
        }
        return moves;
    }

}
