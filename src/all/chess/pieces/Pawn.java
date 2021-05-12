package all.chess.pieces;

import all.chess.Team;
import all.chess.board.*;

import java.util.HashSet;

public class Pawn extends Piece {
    private final int BLACK_START = 1;
    private final int WHITE_START = 6;
    public Pawn(int[] coordinate, Team team) {
        super(coordinate, team);
    }

    @Override
    public HashSet<Move> legalMoves(Board board) {
        HashSet<Move> moves = new HashSet<>();
        if (this.getTeam() == Team.WHITE) { // white pieces move "down"
            int[] forwardOne = {row - 1, col};
            if (BoardUtils.isValidCoordinate(forwardOne) && board.getTile(forwardOne).isEmpty()) {
                Move toAdd = new Move(board, this, forwardOne);
                moves.add(toAdd);
                int[] forwardTwo = {row - 2, col};
                boolean isStart = row == WHITE_START;
                if (isStart && BoardUtils.isValidCoordinate(forwardTwo) && board.getTile(forwardTwo).isEmpty()) {
                    Move toAdd2 = new Move(board, this, forwardTwo);
                    moves.add(toAdd2);
                }
            }
            int[] diagonalLeft = {row - 1, col - 1};
            if (BoardUtils.isValidCoordinate(diagonalLeft)) {
                Tile destinationTile = board.getTile(diagonalLeft);
                Piece victim = destinationTile.getPiece();
                if (destinationTile.isOccupied() && victim.getTeam() == Team.BLACK) {
                    AttackMove pawnCapture = new AttackMove(board, this, diagonalLeft, victim);
                    moves.add(pawnCapture);
                }
            }
            int[] diagonalRight = {row - 1, col + 1};
            if (BoardUtils.isValidCoordinate(diagonalRight)) {
                Tile destinationTile = board.getTile(diagonalRight);
                Piece victim = destinationTile.getPiece();
                if (destinationTile.isOccupied() && victim.getTeam() == Team.BLACK) {
                    AttackMove pawnCapture = new AttackMove(board, this, diagonalRight, victim);
                    moves.add(pawnCapture);
                }
            }
        } else if (this.getTeam() == Team.BLACK) {
            int[] forwardOne = {row + 1, col};
            if (BoardUtils.isValidCoordinate(forwardOne) && board.getTile(forwardOne).isEmpty()) {
                Move toAdd = new Move(board, this, forwardOne);
                moves.add(toAdd);
                int[] forwardTwo = {row + 2, col};
                boolean isStart = row == BLACK_START;
                if (isStart && BoardUtils.isValidCoordinate(forwardTwo) && board.getTile(forwardTwo).isEmpty()) {
                    Move toAdd2 = new Move(board, this, forwardTwo);
                    moves.add(toAdd2);
                }
            }
            int[] diagonalLeft = {row + 1, col - 1};
            if (BoardUtils.isValidCoordinate(diagonalLeft)) {
                Tile destinationTile = board.getTile(diagonalLeft);
                Piece victim = destinationTile.getPiece();
                if (destinationTile.isOccupied() && victim.getTeam() == Team.WHITE) {
                    AttackMove pawnCapture = new AttackMove(board, this, diagonalLeft, victim);
                    moves.add(pawnCapture);
                }
            }
            int[] diagonalRight = {row + 1, col + 1};
            if (BoardUtils.isValidCoordinate(diagonalRight)) {
                Tile destinationTile = board.getTile(diagonalRight);
                Piece victim = destinationTile.getPiece();
                if (destinationTile.isOccupied() && victim.getTeam() == Team.WHITE) {
                    AttackMove pawnCapture = new AttackMove(board, this, diagonalRight, victim);
                    moves.add(pawnCapture);
                }
            }
        }
        return moves;
    }

    @Override
    public String toString() {
        if (team == Team.BLACK){
            return "p";
        }
        return "P";
    }
}
