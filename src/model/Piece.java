package model;

import java.util.ArrayList;
import model.Board;
/**
 * Created by hell on 26/08/14.
 */
public abstract class Piece {
    public static enum ColorPiece {BLACK,WHITE};
    ColorPiece color;
    Cell actualCell;
    Board map;
    Cell nextCell;
    Player p;
    public boolean firstTurn=true;
    ArrayList<Vector> listPosibleMoves = new ArrayList<Vector>();
    public abstract void pieceMovements();
    public abstract ArrayList getPosibleMoves();
    public abstract void movePiece(int x, int y);
    public Piece(ColorPiece color){
        this.color = color;
    }

}
