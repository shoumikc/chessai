package all.chess.pieces;

import all.chess.Color;
import all.chess.board.*;

import java.util.HashSet;

public class Pawn extends Piece {
    final int BLACK_START = 1;
    final int WHITE_START = 5;
    Pawn(int[] coordinate, Color team) {
        super(coordinate, team);
    }

    @Override
    public HashSet<Move> legalMoves(Board board) {
        HashSet<Move> moves = new HashSet<>();
        if (this.getTeam() == Color.WHITE) { // white pieces move "down"
            int[] forwardOne = {row - 1, col};
            if (BoardUtils.isValidCoordinate(forwardOne) && board.getTile(forwardOne).isEmpty()) {
                Move toAdd = new Move(board, this, forwardOne);
                moves.add(toAdd);
                int[] forwardTwo = {row - 2, col};
                boolean isStart = row == 6;
                if (isStart && BoardUtils.isValidCoordinate(forwardTwo) && board.getTile(forwardTwo).isEmpty()) {
                    Move toAdd2 = new Move(board, this, forwardTwo);
                    moves.add(toAdd2);
                }
            }
            int[] diagonalLeft = {row - 1, col - 1};
            if (BoardUtils.isValidCoordinate(diagonalLeft)) {
                Tile destinationTile = board.getTile(diagonalLeft);
                Piece victim = destinationTile.getPiece();
                if (destinationTile.isOccupied() && victim.getTeam() == Color.BLACK) {
                    AttackMove pawnCapture = new AttackMove(board, this, diagonalLeft, victim);
                    moves.add(pawnCapture);
                }
            }
            int[] diagonalRight = {row - 1, col + 1};
            if (BoardUtils.isValidCoordinate(diagonalRight)) {
                Tile destinationTile = board.getTile(diagonalRight);
                Piece victim = destinationTile.getPiece();
                if (destinationTile.isOccupied() && victim.getTeam() == Color.BLACK) {
                    AttackMove pawnCapture = new AttackMove(board, this, diagonalRight, victim);
                    moves.add(pawnCapture);
                }
            }
        } else if (this.getTeam() == Color.BLACK) {
            int[] forwardOne = {row + 1, col};
            if (BoardUtils.isValidCoordinate(forwardOne) && board.getTile(forwardOne).isEmpty()) {
                Move toAdd = new Move(board, this, forwardOne);
                moves.add(toAdd);
                int[] forwardTwo = {row + 2, col};
                boolean isStart = row == 1;
                if (isStart && BoardUtils.isValidCoordinate(forwardTwo) && board.getTile(forwardTwo).isEmpty()) {
                    Move toAdd2 = new Move(board, this, forwardTwo);
                    moves.add(toAdd2);
                }
            }
            int[] diagonalLeft = {row + 1, col - 1};
            if (BoardUtils.isValidCoordinate(diagonalLeft)) {
                Tile destinationTile = board.getTile(diagonalLeft);
                Piece victim = destinationTile.getPiece();
                if (destinationTile.isOccupied() && victim.getTeam() == Color.WHITE) {
                    AttackMove pawnCapture = new AttackMove(board, this, diagonalLeft, victim);
                    moves.add(pawnCapture);
                }
            }
            int[] diagonalRight = {row + 1, col + 1};
            if (BoardUtils.isValidCoordinate(diagonalRight)) {
                Tile destinationTile = board.getTile(diagonalRight);
                Piece victim = destinationTile.getPiece();
                if (destinationTile.isOccupied() && victim.getTeam() == Color.WHITE) {
                    AttackMove pawnCapture = new AttackMove(board, this, diagonalRight, victim);
                    moves.add(pawnCapture);
                }
            }
        }
        return moves;
    }
}
