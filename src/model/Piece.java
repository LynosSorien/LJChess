package model;

import java.util.ArrayList;

/**
 * Created by hell on 26/08/14.
 */
public abstract class Piece {
    public static enum ColorPiece {BLACK,WHITE};
    ColorPiece color;
    Cell cellused;
    ArrayList<Vector> listPosibleMoves = new ArrayList<Vector>();
    public abstract void pieceMovements();
    public abstract ArrayList getPosibleMoves();
    public Piece(ColorPiece color){
        this.color = color;
    }

}
