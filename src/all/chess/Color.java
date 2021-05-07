package all.chess;

public enum Color {
    BLACK, WHITE;

    public static Color getOpposite(Color team){
        if (team == WHITE){
            return BLACK;
        } else{
            return WHITE;
        }
    }
}
