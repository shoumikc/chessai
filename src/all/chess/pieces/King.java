package all.chess.pieces;

import all.chess.Color;
import all.chess.board.*;

import java.util.HashSet;

public class King extends Piece {
    King(int[] coordinate, Color team) {
        super(coordinate, team);
    }

    @Override
    public HashSet<Move> legalMoves(Board board) {
        HashSet<Move> moves = new HashSet<>();
        for (int i = -1; i < 2; i++){
            for (int j = -1; j < 2; j++){
                if (i == 0 && j == 0){
                    continue;
                }
                int[] destinationCoord = {i,j};
                if (BoardUtils.isValidCoordinate(destinationCoord)){
                    Tile destinationTile = board.getTile(destinationCoord);
                    if (destinationTile.isEmpty()){
                        Move toAdd = new Move(board, this, destinationCoord);
                        moves.add(toAdd);
                    } else{
                        Piece victim = destinationTile.getPiece();
                        if (victim != null && victim.getTeam() != this.getTeam()){
                            AttackMove toAdd = new AttackMove(board,this,destinationCoord,victim);
                            moves.add(toAdd);
                        }
                    }
                }
            }
        }
        return moves;
    }
}
