package model;

import java.util.ArrayList;

/**
 * Created by hell on 26/08/14.
 */
public class Pawn extends Piece {
    MoveCell start;
    int row = cellused.getI();
    int col = cellused.getJ();
    Vector posibleMove = new Vector(row,col);
    public Pawn(ColorPiece color){
        super(color);
    }
    @Override
    public void pieceMovements() {
        if (color.equals(ColorPiece.BLACK)){
            listPosibleMoves.add(posibleMove.setX(row+1));
            if (start.pawnStartMove())listPosibleMoves.add(posibleMove.setX(row+2));
        }
        else {
            listPosibleMoves.add(posibleMove.setX(row-1));
            if (start.pawnStartMove())listPosibleMoves.add(posibleMove.setX(row-2));
        }
    }

    @Override
    public ArrayList getPosibleMoves() {
        return listPosibleMoves;
    }
}