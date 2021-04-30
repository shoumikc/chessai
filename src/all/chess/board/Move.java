package all.chess.board;

import all.chess.pieces.Piece;

public class Move {
    private final int destination;
    private final Piece piece;

    Move(Piece pieceToMove, int destination){
        this.piece = pieceToMove;
        this.destination = destination;
    }
    static class AttackMove extends Move{
        AttackMove(Piece pieceToMove, int destination) {
            super(pieceToMove, destination);
        }
    }
}
