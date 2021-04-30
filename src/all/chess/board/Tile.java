/* Created by Shoumik Chaudhuri on 4/20/2021 */
package all.chess.board;

import all.chess.pieces.Piece;

import java.util.HashMap;

public abstract class Tile {
    private int coordinate; // First digit = row; second digit = column
    private Piece piece;
    Tile(int coordinate, Piece piece){
        this.coordinate = coordinate;
        this.piece = piece;
    }
    private static class EmptyTile extends Tile { // tiles with no coordinate
        EmptyTile(int coordinate){
            super(coordinate, null);
        }
    }
    private static class OccupiedTile extends Tile {
        OccupiedTile(int coordinate, Piece piece){
            super(coordinate,piece);
        }
    }

    public int coordinate(){ // coordinate getter
        return this.coordinate;
    }
    public Piece piece(){ // piece getter
        return this.piece;
    }
    public boolean isEmpty(){
        return this.piece == null;
    }

    public static Tile newTile(int coordinate, Piece piece) { // constructor
        Tile result;
        if (piece == null){
            result = new EmptyTile(coordinate);
        } else {
            result = new OccupiedTile(coordinate, piece);
        }
        return result;
    }

}