/* Created by Shoumik Chaudhuri on 4/20/2021 */
package all.chess.pieces;

import all.chess.Color;
import all.chess.board.Board;
import all.chess.board.Move;

import java.util.HashSet;

public abstract class Piece {
    protected final int coordinates;
    protected final Color team;

    Piece(int coordinate, Color team) {
        this.coordinates = coordinate;
        this.team = team;
    }
    /** Returns hashset of legal moves from current board */
    public abstract HashSet<Move> legalMoves(Board board);
    
}
