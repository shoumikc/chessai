package all.chess.pieces;

import all.chess.Color;
import all.chess.board.*;

import java.util.ArrayList;
import java.util.HashSet;

public class Bishop extends Piece {
    Bishop(int[] coordinate, Color team) {
        super(coordinate, team);
    }

    @Override
    public HashSet<Move> legalMoves(Board board) {
        HashSet<Move> moves = new HashSet<>();
        moves.addAll(diagonalTraverser(board, row, col, -1, 1)); // topright
        moves.addAll(diagonalTraverser(board, row, col, -1, -1)); // topleft
        moves.addAll(diagonalTraverser(board, row, col, 1, 1)); // bottomright
        moves.addAll(diagonalTraverser(board, row, col, 1, -1)); //bottomleft
        return moves;
    }

    private ArrayList<Move> diagonalTraverser(Board board, int row, int col, int rowOffset, int colOffset) {
        ArrayList<Move> moves = new ArrayList<>();
        int newRow = row + rowOffset;
        int newCol = col + colOffset;
        while (BoardUtils.isValidCoordinate(newRow, newCol)) {
            int[] destinationCoord = {newRow, newCol};
            Tile destinationTile = board.getTile(destinationCoord);
            if (destinationTile.isEmpty()) {
                Move toAdd = new Move(board, this, destinationCoord);
                moves.add(toAdd);
                newRow += rowOffset;
                newCol += colOffset;
            } else {
                Piece potentialVictim = destinationTile.getPiece();
                if (potentialVictim.getTeam() != this.getTeam()) {
                    AttackMove toAdd = new AttackMove(board, this, destinationCoord, potentialVictim);
                    moves.add(toAdd);
                }
                break;
            }
        }
        return moves;
    }
}

