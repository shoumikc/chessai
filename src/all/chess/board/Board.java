package all.chess.board;

import all.chess.Team;
import all.chess.pieces.*;
import all.chess.player.BlackPlayer;
import all.chess.player.WhitePlayer;

import java.util.ArrayList;
import java.util.HashSet;

public class Board {
    /** Builder pattern used to return Board object;
     * Builder must be used to create boards */
    public static class BoardBuilder {
        Team nextMover;
        Piece[][] boardLayout = new Piece[8][8];
        public BoardBuilder(){}
        public BoardBuilder setPiece(Piece piece){
            int row = piece.getRow();
            int col = piece.getCol();
            boardLayout[row][col] = piece;
            return this;
        }
        public BoardBuilder setNextMover(Team team){
            nextMover = team;
            return this;
        }
        public Board build(){
            return new Board(this);
        }
    }
    /** board is 8x8 matrix, each element has a Tile */
    private final Tile[][] board = new Tile[8][8];
    /** list of all current white pieces */
    private ArrayList<Piece> whitePieces;
    /** list of all currente black pieces */
    private ArrayList<Piece> blackPieces;
    /** set of all white legal moves */
    HashSet<Move> whiteMoves;
    /** set of all black legal moves */
    HashSet<Move> blackMoves;
    WhitePlayer whitePlayer;
    BlackPlayer blackPlayer;

    /** Private constructor since u must use BoardBuilder */
    private Board(BoardBuilder builder){
        Piece[][] layout = builder.boardLayout;
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                int[] coordinate = {i,j};
                board[i][j] = new Tile(coordinate, layout[i][j]);
            }
        }
        whitePieces = getPieces(Team.WHITE);
        blackPieces = getPieces(Team.BLACK);

        whiteMoves = getTeamMoves(whitePieces);
        blackMoves = getTeamMoves(blackPieces);

        whitePlayer = new WhitePlayer(this, whiteMoves, blackMoves);
        blackPlayer = new BlackPlayer(this, blackMoves, whiteMoves);


    }
    /** Returns list of pieces on board given a team */
    private ArrayList<Piece> getPieces(Team team){
        ArrayList<Piece> result = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                Tile tile = board[i][j];
                if (tile.isOccupied() && tile.getPiece().getTeam() == team){
                    result.add(tile.getPiece());
                }
            }
        }
        return result;
    }
    /** Returns set of all legal moves for given team pieces */
    private HashSet<Move> getTeamMoves(ArrayList<Piece> pieceList){
        HashSet<Move> moves = new HashSet<>();
        for (Piece piece : pieceList){
            HashSet<Move> currentMoves = piece.legalMoves(this);
            moves.addAll(currentMoves);
        }
        return moves;
    }

    /** Builds and returns the standard starting board */
    static public Board createStartingBoard(){
        BoardBuilder builder = new BoardBuilder();
        // WHITE PIECES
        // taking care of Pawn row:
        for (int j = 0; j < 8; j++){
            int[] coordinate = {6,j};
            builder.setPiece(new Pawn(coordinate, Team.WHITE));
        }
        builder.setPiece(new Rook(new int[]{7,0}, Team.WHITE));
        builder.setPiece(new Knight(new int[]{7,1}, Team.WHITE));
        builder.setPiece(new Bishop(new int[]{7,2}, Team.WHITE));
        builder.setPiece(new Queen(new int[]{7,3}, Team.WHITE));
        builder.setPiece(new King(new int[]{7,4}, Team.WHITE));
        builder.setPiece(new Bishop(new int[]{7,5}, Team.WHITE));
        builder.setPiece(new Knight(new int[]{7,6}, Team.WHITE));
        builder.setPiece(new Rook(new int[]{7,7}, Team.WHITE));

        // BLACK PIECES
        // taking care of Pawn row:
        for (int j = 0; j < 8; j++) {
            int[] coordinate = {1, j};
            builder.setPiece(new Pawn(coordinate, Team.BLACK));
        }
        builder.setPiece(new Rook(new int[]{0,0}, Team.BLACK));
        builder.setPiece(new Knight(new int[]{0,1}, Team.BLACK));
        builder.setPiece(new Bishop(new int[]{0,2}, Team.BLACK));
        builder.setPiece(new Queen(new int[]{0,3}, Team.BLACK));
        builder.setPiece(new King(new int[]{0,4}, Team.BLACK));
        builder.setPiece(new Bishop(new int[]{0,5}, Team.BLACK));
        builder.setPiece(new Knight(new int[]{0,6}, Team.BLACK));
        builder.setPiece(new Rook(new int[]{0,7}, Team.BLACK));

        builder.setNextMover(Team.WHITE);
        return builder.build();
    }

    public Tile getTile(int[] coordinate){
        int row = coordinate[0];
        int col = coordinate[1];
        return board[row][col];
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                Tile tile = board[i][j];
                if (tile.isEmpty()){
                    builder.append("- ");
                } else {
                    Piece piece = tile.getPiece();
                    builder.append(piece.toString()).append(" ");
                }
                if (j == 7){
                    builder.append("\n");
                }
            }
        }
        return builder.toString();
    }
}
