/* Created by Shoumik Chaudhuri on 4/20/2021 */
package all.chess.board;

import all.chess.pieces.Piece;

import java.util.HashMap;

public class Tile {
    private int coordinate; // First digit = row; second digit = column
    private Piece piece;
    Tile(int coordinate, Piece piece){ // occupied Tile
        this.coordinate = coordinate;
        this.piece = piece;
    }
    Tile(int coordinate){ // Empty Tile
        this(coordinate, null);
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
            result = new Tile(coordinate);
        } else {
            result = new Tile(coordinate, piece);
        }
        return result;
    }

}