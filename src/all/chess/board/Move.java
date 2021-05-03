package all.chess.board;

import all.chess.pieces.Piece;

public class Move {
    private final int[] destination;
    private final Piece piece;
    private final Board board;

    public Move(Board board, Piece pieceToMove, int[] destination){
        this.piece = pieceToMove;
        this.destination = destination;
        this.board = board;
    }

    static class AttackMove extends Move{
        Piece victim;
        AttackMove(Board board, Piece pieceToMove, int[] destination, Piece victim) {
            super(board, pieceToMove, destination);
            this.victim = victim;
        }
    }
}
