package all.chess;

public enum Team {
    BLACK, WHITE;

    public static Team getOpposite(Team team){
        if (team == WHITE){
            return BLACK;
        } else{
            return WHITE;
        }
    }
}
