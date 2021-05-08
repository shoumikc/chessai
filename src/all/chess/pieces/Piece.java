/* Created by Shoumik Chaudhuri on 4/20/2021 */
package all.chess.pieces;

import all.chess.Team;
import all.chess.board.Board;
import all.chess.board.BoardUtils;
import all.chess.board.Move;

import java.util.HashSet;

public abstract class Piece {
    protected final int[] coordinate;
    protected final Team team;
    protected final int row;
    protected final int col;

    Piece(int[] coordinate, Team team) {
        this.coordinate = coordinate;
        this.team = team;
        this.row = BoardUtils.getRow(this.coordinate);
        this.col = BoardUtils.getCol(this.coordinate);
    }

    /** Returns hashset of legal moves from current board */
    public abstract HashSet<Move> legalMoves(Board board);
    /** Returns coordinates of piece */
    public int[] getCoordinate(){return coordinate;}
    /** Returns row coord of piece */
    public int getRow() {return row;}
    /** Returns col coord of piece */
    public int getCol() {return col;}
    /** Returns color of piece */
    public Team getTeam(){return team;}

    
}
