package all.chess.pieces;

import all.chess.Team;
import all.chess.board.*;

import java.util.HashSet;

public class Bishop extends Piece {
    public Bishop(int[] coordinate, Team team) {
        super(coordinate, team);
    }

    @Override
    public HashSet<Move> legalMoves(Board board) {
        HashSet<Move> moves = new HashSet<>();
        diagonalTraverser(moves, board, -1, 1); // topright
        diagonalTraverser(moves, board, -1, -1); // topleft
        diagonalTraverser(moves, board, 1, 1); // bottomright
        diagonalTraverser(moves, board, 1, -1); //bottomleft
        return moves;
    }

    @Override
    public String toString() {
        if (team == Team.BLACK){
            return "b";
        }
        return "B";
    }

    /** Helper method for Bishop that traverses all 4 diagonals */
    private void diagonalTraverser(HashSet<Move> set, Board board, int rowOffset, int colOffset) {
        int newRow = row + rowOffset;
        int newCol = col + colOffset;
        while (BoardUtils.isValidCoordinate(newRow, newCol)) {
            int[] destinationCoord = {newRow, newCol};
            Tile destinationTile = board.getTile(destinationCoord);
            if (destinationTile.isEmpty()) {
                Move toAdd = new Move(board, this, destinationCoord);
                set.add(toAdd);
                newRow += rowOffset;
                newCol += colOffset;
            } else {
                Piece potentialVictim = destinationTile.getPiece();
                if (potentialVictim.getTeam() != this.getTeam()) {
                    AttackMove toAdd = new AttackMove(board, this, destinationCoord, potentialVictim);
                    set.add(toAdd);
                }
                break; // can't jump pieces, so we must break at the occurance of an obstacle
            }
        }
    }
}

