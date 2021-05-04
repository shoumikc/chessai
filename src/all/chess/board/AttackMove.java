package all.chess.board;

import all.chess.pieces.Piece;

public class AttackMove extends Move {
    private Piece victim;
    public AttackMove(Board board, Piece pieceToMove, int[] destination, Piece victim) {
        super(board, pieceToMove, destination);
        this.victim = victim;
    }
    public Piece getVictim(){
        return this.victim;
    }
}
