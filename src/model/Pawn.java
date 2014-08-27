package model;

import java.util.ArrayList;

/**
 * Created by hell on 26/08/14.
 */
public class Pawn extends Piece {
    int moveI;
    int moveJ;
    public Pawn(String color){
        super(color);
    }
    @Override
    public void pieceMovements() {
        moveI = cellused.getI();
        moveJ = cellused.getJ();
        if (color == "BLACK"){
            moveI++;
            listPosibleMoves.add();
        }
        else {
            listPosibleMoves.add(moveI-1);
        }

        /*if (cellused.isMoveCell() && cellused.getColorpiece() == Cell.ColorPiece.WHITE){
            //i++ o i+=2
            listPosibleMoves.add(cellused.getI()+1);
            listPosibleMoves.add(cellused.getI()+2);

        }*/
    }

    @Override
    public ArrayList getPosibleMoves() {
        return null;
    }
}