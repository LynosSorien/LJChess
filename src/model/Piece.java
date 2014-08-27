package model;

import java.util.ArrayList;

/**
 * Created by hell on 26/08/14.
 */
public abstract class Piece {
    public static enum ColourPiece {BLACK,WHITE};
    Cell cellused;
    String color;
    ArrayList listPosibleMoves = new ArrayList();
    public abstract void pieceMovements();
    public abstract ArrayList getPosibleMoves();
    public Piece(String color){
        this.color = color;
    }

}
