package all.chess.board;

public class BoardUtils {
    private static final int  MAX_ROW = 7;
    private static final int MAX_COL = 7;
    /** returns row # from coordinate */
    static int getRow(int coordinate){
        return Math.floorDiv(coordinate,10);
    }
    /** returns col # from coordinate */
    static int getCol(int coordinate){
        return coordinate % 10;
    }
    /** returns True iff coordinate is valid */
    static boolean isValidCoordinate(int coordinate){
        int row = getRow(coordinate);
        int col = getCol(coordinate);
        return (row < MAX_ROW && row >= 0 && col < MAX_COL & col >= 0);
    }


}
