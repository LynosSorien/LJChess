package model;

import java.util.ArrayList;

/**
 * Created by hell on 26/08/14.
 */
public class Pawn extends Piece {
    private MoveCell start;
    private int row = cellused.getI();
    private int col = cellused.getJ();
    public Pawn(ColorPiece color){
        super(color);
    }
    @Override
    public void pieceMovements() {
        if (color.equals(ColorPiece.BLACK)){
            listPosibleMoves.add(new Vector(row+1,col));
            if (start.pawnStartMove())listPosibleMoves.add(new Vector(row+2,col));
        }
        else {
            listPosibleMoves.add(new Vector(row-1,col));
            if (start.pawnStartMove())listPosibleMoves.add(new Vector(row-2,col));
        }
    }

    @Override
    public ArrayList getPosibleMoves() {
        return listPosibleMoves;
    }
}
