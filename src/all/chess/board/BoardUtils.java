package all.chess.board;

public class BoardUtils {
    private static final int  MAX_ROW = 8;
    private static final int MAX_COL = 8;
    /** returns row # from coordinate */
    public static int getRow(int[] coordinate){
         return coordinate[0];
    }
    /** returns col # from coordinate */
    public static int getCol(int[] coordinate){
        return coordinate[1];
    }
    /** returns True iff coordinate is valid */
    public static boolean isValidCoordinate(int[] coordinate){
        int row = getRow(coordinate);
        int col = getCol(coordinate);
        return (row < MAX_ROW && row >= 0 && col < MAX_COL & col >= 0);
    }
    /** Same as above, but doesnt require arr format */
    public static boolean isValidCoordinate(int row, int col){
        int[] arr = {row, col};
        return isValidCoordinate(arr);
    }


}
