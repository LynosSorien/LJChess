package model;

import java.util.ArrayList;

/**
 * Created by hell on 26/08/14.
 */
public class Pawn extends Piece {
    MoveCell start;
    int move;

    @Override
    public void pieceMovements() {
        move = cellused.getI();
        if (cellused.isMoveCell() && cellused.getColorpiece() == Cell.ColorPiece.WHITE){
            //i++ o i+=2
            listPosibleMoves.add(cellused.getI()+1);
            listPosibleMoves.add(cellused.getI()+2);

        }
    }

    @Override
    public ArrayList getPosibleMoves() {
        return null;
    }
}