package model;

import java.util.ArrayList;
import model.Board;
/**
 * Created by hell on 26/08/14.
 */
public abstract class Piece {
    public static enum ColorPiece {BLACK,WHITE};
    protected ColorPiece color;
    protected Cell actualCell;
    //protected Board map;
    protected Cell nextCell;
    //protected Player p;
    protected boolean firstTurn=true;
    protected ArrayList<Vector> listPosibleMoves = new ArrayList<Vector>() {
        @Override
        public String toString() {
            String print = new String("");
            for(int i = 0; i<size();i++)
                print+=get(i);
            return print;
        }
    };
    public abstract void pieceMovements(Board map);
    public ArrayList getPosibleMoves(Board map){
        ArrayList<Vector> tmp = listPosibleMoves;
        listPosibleMoves= new ArrayList<Vector>();
        return tmp;
    }
    public abstract void movePiece(int x, int y, Board map,Player p);
    public Piece(ColorPiece color){
        this.color = color;
    }
    public <C extends Cell> C setActualCell(C cell) {this.actualCell = cell; return (C)actualCell;}
    public ColorPiece getColor() {return color;}
}
