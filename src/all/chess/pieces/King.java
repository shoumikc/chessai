package all.chess.pieces;

import all.chess.Color;
import all.chess.board.Board;
import all.chess.board.Move;

import java.util.HashSet;

public class King extends Piece {
    King(int[] coordinate, Color team) {
        super(coordinate, team);
    }

    @Override
    public HashSet<Move> legalMoves(Board board) {
        HashSet<Move> moves = new HashSet<>();
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                if (i == 1 && j == 1){
                    continue;
                }
                int[] destinationCoord = {i,j};

            }
        }
        return moves;
    }
}
