package all.chess.pieces;

import all.chess.Color;
import all.chess.board.Board;
import all.chess.board.Move;

import java.util.HashSet;

public class Bishop extends Piece {
    Bishop(int[] coordinate, Color team) {
        super(coordinate, team);
    }

    @Override
    public HashSet<Move> legalMoves(Board board) {

    }
}
