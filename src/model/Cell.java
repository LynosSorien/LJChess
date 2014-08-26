package model;

/**
 * Created by hell on 26/08/14.
 */
public class Cell implements ICell{

    public static enum CellState {NULL, ROOK, KNIGHT, BISHOP, QUEEN, KING, PAWN};

    //Fields
    private int i;
    private int j;
    //String status;
    private Cell.CellState status;
    private boolean isCrownCell;
    private boolean isMoveCell;
    private Class<? extends Piece> p;
    //Constructor
    public Cell(int x, int y, Cell.CellState initStatus, Class<? extends Piece> piece) {
        i=x;
        j=y;
        status=initStatus;
        this.p = piece;
    }
    //Getters and setters
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public Cell.CellState getStatus() {
        return status;
    }

    public void setStatus(Cell.CellState status) {
        this.status = status;
    }

    // Interface methods
    @Override
    public boolean damageCell() {
        return false;
    }

    @Override
    public Piece getPiece() {
        return null;
    }

    @Override
    public boolean isOccupied() {
        return false;
    }
}
