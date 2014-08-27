package model;

/**
 * Created by hell on 26/08/14.
 */
public class MoveCell extends Cell{
    private Board board;
    public MoveCell(int x, int y, CellState initStatus, Piece piece) {
        super(x, y, initStatus, piece);
    }
    public boolean pawnStartMove(){
        boolean isPawnInMoveCell=false;
        if (getStatus()==CellState.PAWN){isPawnInMoveCell=true;}
        return isPawnInMoveCell;
    }

}
