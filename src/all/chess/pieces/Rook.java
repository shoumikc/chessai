package all.chess.pieces;

import all.chess.Team;
import all.chess.board.*;

import java.util.HashSet;

public class Rook extends Piece{
    public Rook(int[] coordinate, Team team) {
        super(coordinate, team);
    }

    @Override
    public HashSet<Move> legalMoves(Board board) {
        HashSet<Move> moves = new HashSet<>();
        horizontalTraverser(moves,board,1,0); // down
        horizontalTraverser(moves, board, -1, 0); // up
        horizontalTraverser(moves, board, 0, 1); // right
        horizontalTraverser(moves, board, 0,-1); // left
        return moves;
    }

    @Override
    public String toString() {
        if (team == Team.BLACK){
            return "r";
        }
        return "R";
    }

    /** Helper method for Rook that traverses all 4 horizontals */
    private void horizontalTraverser(HashSet<Move> set, Board board, int rowOffset, int colOffset){
        int newRow = row + rowOffset;
        int newCol = col + colOffset;
        while (BoardUtils.isValidCoordinate(newRow, newCol)){
            int[] destinationCoord = {newRow, newCol};
            Tile destinationTile = board.getTile(destinationCoord);
            if (destinationTile.isEmpty()){
                Move toAdd = new Move(board, this, destinationCoord);
                set.add(toAdd);
                newRow += rowOffset;
                newCol += colOffset;
            } else {
                Piece potentialVictim = destinationTile.getPiece();
                if (potentialVictim.getTeam() != this.getTeam()){
                    AttackMove toAdd = new AttackMove(board, this, destinationCoord, potentialVictim);
                }
                break;
            }
        }
    }


}
